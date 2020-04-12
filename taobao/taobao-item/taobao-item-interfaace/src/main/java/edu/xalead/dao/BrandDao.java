package edu.xalead.dao;

import edu.xalead.item.entity.Brand;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

public interface BrandDao extends Mapper<Brand> {

    @Insert("insert into tb_category_brand (category_id,brand_id) values(#{id},#{ci})")
    Integer addBrandCategory(@Param("id") Long id, @Param("ci") Long ci);
}
