package edu.xalead.controller;

import edu.xalead.item.entity.Category;
import edu.xalead.service.CategoryService;
import org.apache.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("category")
public class CategoryController {
    @Resource
    private CategoryService categoryService;
    @GetMapping("list")
    public ResponseEntity<List<Category>> list(@RequestParam("pid") Integer pid){
        List<Category> categories = categoryService.list(pid);

        return ResponseEntity.ok(categories);
    }
}
