package edu.xalead.service;

import edu.xalead.dao.SpecParamDao;
import edu.xalead.item.entity.SpecParam;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class SpecParamService {
    @Resource
    private SpecParamDao specParamDao;


    public List<SpecParam> selectParams(Long gid,Long cid,Boolean searching) {
        SpecParam specParam = new SpecParam();
        specParam.setGroupId(gid);
        specParam.setCid(cid);
        specParam.setSearching(searching);
        List<SpecParam> select = specParamDao.select(specParam);
        return select;
    }
}
