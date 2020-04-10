package edu.xalead.item.entity;

import com.sun.org.apache.xpath.internal.operations.Bool;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "tb_category")
@Data
public class Category {
    @Id
    private Integer id;
    private String name;
    private Integer parentId;
    private Boolean isParent;
    private Integer sort;
}
