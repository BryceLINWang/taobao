package edu.xalead.item.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Id;
import javax.persistence.Table;

@Data
@AllArgsConstructor
@NoArgsConstructor
//
@Table(name="t_item")
public class Item {
    @Id
    private Integer id;
    private String name;
    private double  price;
}
