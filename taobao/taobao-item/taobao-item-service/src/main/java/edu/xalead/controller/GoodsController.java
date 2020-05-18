package edu.xalead.controller;

import edu.xalead.item.entity.Spu;
import edu.xalead.service.GoodsService;
import edu.xalead.vo.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("spu")
public class GoodsController {
    @Resource
    private GoodsService goodsService;
    @GetMapping("page")
    public ResponseEntity<Page> querySpuByPage(
            @RequestParam(value="key",required = false) String key,
            @RequestParam(value="page",defaultValue = "1") Integer page,
            @RequestParam(value="rows",defaultValue = "5") Integer rows,
            @RequestParam(value="saleable") String saleable
    ){
        com.github.pagehelper.Page<Spu> spuPage = goodsService.querySpuByPage(key,saleable,page,rows);
        Page p = new Page(spuPage);

        return ResponseEntity.ok(p);
    }
}
