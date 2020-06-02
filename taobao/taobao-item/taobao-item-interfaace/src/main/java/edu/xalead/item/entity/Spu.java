package edu.xalead.item.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;
@Data
@Table(name="tb_spu")
public class Spu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="title")
    private String title;
    private String subTitle;
    private Long cid1;
    private Long cid2;
    private Long cid3;
    private Long brandId;
    private Boolean saleable;
    private Boolean valid;
    private Date createTime;
    private Date lastUpdateTime;
    //瞬时属性 与数据库无关映射
    @Transient
    private String bname;
    @Transient
    private String cname;

}
