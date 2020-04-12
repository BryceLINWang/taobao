package edu.xalead.service;

import edu.xalead.dao.ItemDao;
import edu.xalead.item.entity.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ItemService {
    @Resource
    private ItemDao itemDao;

    public List<Item> queryAll(){
        return itemDao.selectAll();
    }
}
