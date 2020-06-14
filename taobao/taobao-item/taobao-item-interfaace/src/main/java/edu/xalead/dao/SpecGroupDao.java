package edu.xalead.dao;

import edu.xalead.item.entity.SpecGroup;
import tk.mybatis.mapper.additional.idlist.IdListMapper;
import tk.mybatis.mapper.additional.insert.InsertListMapper;
import tk.mybatis.mapper.common.Mapper;

public interface SpecGroupDao extends Mapper<SpecGroup>, IdListMapper<SpecGroup,Long>, InsertListMapper<SpecGroup> {
}
