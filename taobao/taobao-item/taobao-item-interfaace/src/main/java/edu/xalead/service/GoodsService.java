package edu.xalead.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import edu.xalead.common.exception.SystemExceptionEnum;
import edu.xalead.common.exception.TBSystemException;
import edu.xalead.dao.*;
import edu.xalead.item.entity.*;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class GoodsService {
    @Resource
    private SpuDao spuDao;
    @Resource
    private SpuDetailDao spuDetailDao;
    @Resource
    private CategoryDao categoryDao;
    @Resource
    private BrandDao brandDao;
    @Resource
    private SkuDao skuDao;
    @Resource
    private StockDao stockDao;
    public Page<Spu> querySpuByPage(String key, String saleable, Integer page, Integer rows) {
        //分布
        PageHelper.startPage(page,rows);
        Example example = new Example(Spu.class);
        //过滤
        if(StringUtils.isNotBlank(key)){
            //过滤条件
            example.createCriteria().orLike("title",key)
                    .andEqualTo("saleable",saleable);
        }
        //排序
        example.setOrderByClause("last_update_time desc");//按最后更新时间默认排序 升（降）
        //查询
        Page<Spu> ss =
                (Page<Spu>) spuDao.selectByExample(example);
        for(Spu spu :ss){
            //设置分类的名称
            List<Long> ids = Arrays.asList(spu.getCid1(),spu.getCid2(),spu.getCid3());
            List<Category> categories = categoryDao.selectByIdList(ids);
            StringBuffer str = new StringBuffer();
            for(Category c:categories){
                str.append(c.getName()).append("/");
            }
            spu.setCname(str.toString());
            //设置品牌名称
            Brand brand = brandDao.selectByPrimaryKey(spu.getBrandId());
            spu.setBname(brand.getName());
        }
        return ss;
    }

    public Integer addSpu(Spu spu) {
        return spuDao.insert(spu);
    }

    public Integer addSpuDetail(SpuDetail spuDetail) {

        return spuDetailDao.insert(spuDetail);
    }
    @Transactional
    public void addSkus(List<Sku> skus) {
        Integer count =  skuDao.insertList(skus);
        if(count == 0){
            throw new TBSystemException(SystemExceptionEnum.GOODS_UPDATE_ERROR);
        }
        List<Stock> stocks = new ArrayList<>();
        for(Sku sku : skus){
            Stock stock = new Stock();
            stock.setSkuId(sku.getId());
            stock.setStock(sku.getStock());
            stocks.add(stock);
        }
        count = stockDao.insertList(stocks);
        if(count == 0){
            throw new TBSystemException(SystemExceptionEnum.GOODS_UPDATE_ERROR);
        }
    }
}
