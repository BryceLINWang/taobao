package edu.xalead.controller;

import edu.xalead.common.exception.SystemExceptionEnum;
import edu.xalead.common.exception.TBSystemException;
import edu.xalead.item.entity.Sku;
import edu.xalead.item.entity.Spu;
import edu.xalead.item.entity.SpuDetail;
import edu.xalead.service.GoodsService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@RestController
public class GoodsManaController {
    @Resource
    public GoodsService goodsService;
    @PostMapping("goods")
    public ResponseEntity<Void>goodsAdd(@RequestBody Spu spu){
        ///添加spu的基本属性
        spu.setCreateTime(new Date());
        spu.setLastUpdateTime(new Date());
        spu.setSaleable(true);
        spu.setValid(true);
        Integer count = goodsService.addSpu(spu);
        if(count == 0){
            throw new TBSystemException(SystemExceptionEnum.GOODS_UPDATE_ERROR);
        }


        //添加spu detail属性
        SpuDetail spuDetail =spu.getSpuDetail();
        spuDetail.setSpuId(spu.getId());
        count =  goodsService.addSpuDetail(spuDetail);
        if(count == 0){
            throw new TBSystemException(SystemExceptionEnum.GOODS_UPDATE_ERROR);
        }
        //添加skus
        List<Sku>skus=spu.getSkus();
        for(Sku sku:skus){
            sku.setSpuId(spu.getId());
            sku.setCreateTime(new Date());
            sku.setLastUpdateTime(new Date());
            sku.setEnable(true);
        }
        //添加sku及库存
        goodsService.addSkus(skus);
        return ResponseEntity.ok(null);
    }
}
