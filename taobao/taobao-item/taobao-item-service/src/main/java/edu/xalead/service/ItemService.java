package edu.xalead.service;

import edu.xalead.dao.ItemDao;
import edu.xalead.entity.Item;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class ItemService {
 @Resource
    private ItemDao itemDao;
    public Item saveItem(Item item){
        return itemDao.saveItem(item);
    }
}
