package edu.xalead.vo;

import edu.xalead.item.entity.Brand;
import lombok.Data;

import java.util.List;
@Data
public class Page {
    private List<Brand> data;
    private Long total;
    private Integer totalPage;
    private Integer pageNum;
    private Integer pageSize;
    private Integer startRow;
    private Integer endRow;
}
