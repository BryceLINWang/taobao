package edu.xalead.dao;

import edu.xalead.item.entity.Spu;
import tk.mybatis.mapper.additional.idlist.IdListMapper;
import tk.mybatis.mapper.additional.insert.InsertListMapper;
import tk.mybatis.mapper.common.Mapper;

public interface SpuDao extends Mapper<Spu> , IdListMapper<Spu,Long>, InsertListMapper<Spu> {
}
