package edu.xalead.dao;

import edu.xalead.item.entity.SpecGroup;
import edu.xalead.item.entity.Stock;
import tk.mybatis.mapper.additional.idlist.IdListMapper;
import tk.mybatis.mapper.additional.insert.InsertListMapper;
import tk.mybatis.mapper.common.Mapper;

public interface StockDao extends Mapper<Stock>, IdListMapper<Stock,Long>, InsertListMapper<Stock> {
}
