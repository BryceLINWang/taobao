package edu.xalead.dao;

import edu.xalead.item.entity.SpecParam;
import tk.mybatis.mapper.additional.idlist.IdListMapper;
import tk.mybatis.mapper.additional.insert.InsertListMapper;
import tk.mybatis.mapper.common.Mapper;

public interface SpecParamDao extends Mapper<SpecParam>, IdListMapper<SpecParam,Long>, InsertListMapper<SpecParam> {

}
