package edu.xalead.dao;

import edu.xalead.item.entity.SpuDetail;
import tk.mybatis.mapper.additional.idlist.IdListMapper;
import tk.mybatis.mapper.additional.insert.InsertListMapper;
import tk.mybatis.mapper.common.Mapper;

public interface SpuDetailDao extends Mapper<SpuDetail>, IdListMapper<SpuDetail,Long>, InsertListMapper<SpuDetail> {
}
