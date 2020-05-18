package edu.xalead.dao;

import edu.xalead.item.entity.Category;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface CategoryDao extends Mapper<Category> {

    List<Category> selectByIdList(List<Long> ids);
}
