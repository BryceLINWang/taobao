package edu.xalead.controller;

import com.github.pagehelper.Page;
import edu.xalead.common.exception.TBSystemException;
import edu.xalead.common.exception.SystemExceptionEnum;
import edu.xalead.item.entity.Brand;
import edu.xalead.service.BrandService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Collection;
import java.util.List;
@RestController
@RequestMapping("brand")
public class BrandController {
    @Resource
    private BrandService brandService;

    @GetMapping("page")
    public ResponseEntity<edu.xalead.vo.Page> queryBrandByPage(
            @RequestParam(value="key") String key,
            @RequestParam(value="page",defaultValue = "1") Integer page,
            @RequestParam(value="rows",defaultValue = "5") Integer rows,
            @RequestParam(value="sortBy") String sortBy,
            @RequestParam(value="desc",defaultValue = "false")Boolean desc){
        Page<Brand> lists = brandService.queryBrandByPage(key,page,rows,sortBy,desc);
        edu.xalead.vo.Page p = new edu.xalead.vo.Page(lists);


        return ResponseEntity.ok(p);
    }
    @RequestMapping("cid/{cid}")
    public ResponseEntity<List<Brand>>queryBrandByCid(@PathVariable("cid") Long cid){
        List<Brand> brands= brandService.queryBrandByCid(cid);
        return ResponseEntity.ok(brands);
    }
    @PostMapping("add")
    public void add(Brand brand,String cids){

        if(!StringUtils.isNotBlank(cids)){
            throw new TBSystemException(SystemExceptionEnum.NOT_SELECTED_CATEGORY);
        }
        brandService.addBrand(brand,cids);
    }
}
