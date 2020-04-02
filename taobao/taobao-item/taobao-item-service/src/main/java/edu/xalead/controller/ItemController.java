package edu.xalead.controller;

import edu.xalead.item.entity.Item;
import edu.xalead.service.ItemService;

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
   public List<Item>queryAll(){
       return itemService.queryAll();
   }
}
