package edu.xalead.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import edu.xalead.dao.SpecGroupDao;
import edu.xalead.item.entity.SpecGroup;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class SpecGroupService {
    @Resource
    private SpecGroupDao specGroupDao;

    public List<SpecGroup> specGroupPage(Long cid) {
        SpecGroup g = new SpecGroup();
        g.setCid(cid);
        List<SpecGroup> select = specGroupDao.select(g);
        return select;
    }
}
