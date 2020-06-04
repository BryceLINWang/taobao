package edu.xalead.controller;

import edu.xalead.item.entity.Spu;
import edu.xalead.service.GoodsService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class GoodsManaController {
    @Resource
    public GoodsService goodsService;
    @PostMapping("goods")
    public ResponseEntity<Void>goodsAdd(@RequestBody Spu spu){

        return ResponseEntity.ok(null);
    }
}
