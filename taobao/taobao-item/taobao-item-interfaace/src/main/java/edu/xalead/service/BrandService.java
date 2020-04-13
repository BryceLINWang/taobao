package edu.xalead.service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import edu.xalead.common.exception.TBSystemException;
import edu.xalead.common.exception.SystemExceptionEnum;
import edu.xalead.dao.BrandDao;
import edu.xalead.item.entity.Brand;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.List;
@Service
public class BrandService {
    @Resource
    private BrandDao brandDao;

    public Page<Brand> queryBrandByPage(String key,
                                        Integer page,
                                        Integer rows,
                                        String sortBy,
                                        Boolean desc) {
        //分页
        PageHelper.startPage(page, rows);
        //过滤
        Example example = new Example(Brand.class);
        if (StringUtils.isNotBlank(key)) {
            //过滤条件
            example.createCriteria().orLike("name", key)
                    .orEqualTo("letter", key);
        }
        //排序
        if (StringUtils.isNotBlank(sortBy)) {
            example.setOrderByClause(sortBy + " " + (desc ? "asc" : "desc"));
        }
        //查询
        Page<Brand> list = (Page<Brand>) brandDao.selectByExample(example);
        return list;
    }

    @Transactional
    public Integer addBrand(Brand brand, String cids) {
        //TODO 添加品牌
        int count = brandDao.insert(brand);
        if (count <= 0) {
            throw new TBSystemException(SystemExceptionEnum.ADD_FAIL_EXCEPTION);
        }


        String[] cs = cids.split(",");
        for (String cid : cs) {
            Long ci = Long.parseLong(cid);
            count = brandDao.addBrandCategory(brand.getId(), ci);
            if (count <= 0) {
                throw new TBSystemException(SystemExceptionEnum.ADD_FAIL_EXCEPTION);
            }
        }
        return count;
    }
}
