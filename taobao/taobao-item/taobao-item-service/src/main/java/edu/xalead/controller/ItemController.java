package edu.xalead.controller;


import edu.xalead.exception.TBSystemException;
import edu.xalead.item.entity.Item;
import edu.xalead.service.ItemService;

import org.apache.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController

public class ItemController {
    @Resource
    private ItemService itemService;
    @GetMapping("queryAll")
   public ResponseEntity<List<Item>> queryAll(){
        List<Item>items=itemService.queryAll();
        if(items==null||items.size()==0){
            throw new TBSystemException("查无商品!");
        }
      // return ResponseEntity.status(HttpStatus.SC_OK).body(items);
     return ResponseEntity.ok(items);
    }
}
