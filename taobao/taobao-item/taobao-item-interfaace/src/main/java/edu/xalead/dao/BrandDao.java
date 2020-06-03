package edu.xalead.dao;

import edu.xalead.item.entity.Brand;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface BrandDao extends Mapper<Brand> {

    @Insert("insert into tb_category_brand (category_id,brand_id) values(#{id},#{ci})")
    Integer addBrandCategory(@Param("id") Long id, @Param("ci") Long ci);
    @Select("select b.id,b.name,b.image,b.letter from tb_brand b inner join tb_category_brand c " +
            "ON b.id = c.brand_id " +
            "where c.category_id = #{cid}")
    List<Brand> queryBrandsByCids(@Param("cid") Long cid);
}
