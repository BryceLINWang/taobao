package edu.xalead.dao;

import edu.xalead.item.entity.Category;
import edu.xalead.item.entity.Sku;
import tk.mybatis.mapper.additional.idlist.IdListMapper;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.special.InsertListMapper;

public interface SkuDao extends Mapper<Sku>, IdListMapper<Sku,Long>, InsertListMapper<Sku> {
}
