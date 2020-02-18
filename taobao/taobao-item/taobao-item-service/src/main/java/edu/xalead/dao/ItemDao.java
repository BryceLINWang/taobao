package edu.xalead.dao;
import edu.xalead.entity.Item;
import org.springframework.stereotype.Repository;

import java.util.Random;
@Repository
public class ItemDao {
    public Item saveItem(Item item){
        item.setId(new Random().nextInt(1000));
        return item;
    }
}
