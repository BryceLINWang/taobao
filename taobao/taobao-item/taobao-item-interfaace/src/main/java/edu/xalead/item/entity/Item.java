package edu.xalead.item.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "t_item")
@Data
public class Item {
    @Id
    private Integer id;
    private String name;
    private Double price;
}
