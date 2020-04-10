package edu.xalead.service;

import edu.xalead.dao.CategoryDao;
import edu.xalead.item.entity.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class CategoryService {
    @Resource
    private CategoryDao categoryDao;

    public List<Category> list(Integer pid){
        Category category = new Category();
        category.setParentId(pid);
        return categoryDao.select(category);
    }
}
