package edu.xalead.vo;


import edu.xalead.item.entity.Brand;
import lombok.Data;

import java.util.List;
@Data
public class Page<T> {
    private List<T> data;
    private Long total;
    private Integer totalPage;
    private Integer pageNum;
    private Integer pageSize;
    private Integer startRow;
    private Integer endRow;

    public Page(){}
    public Page(com.github.pagehelper.Page<T> lists) {
        this.setData(lists.getResult());
        this.setTotal(lists.getTotal());
        this.setTotalPage(lists.getPages());
        this.setStartRow(lists.getStartRow());
        this.setEndRow(lists.getEndRow());
        this.setPageSize(lists.getPageSize());
        this.setPageNum(lists.getPageNum());
    }
}
