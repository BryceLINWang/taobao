package edu.xalead.dao;
import edu.xalead.item.entity.Item;

import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.Random;
@Repository
public interface ItemDao extends Mapper<Item> {

}
