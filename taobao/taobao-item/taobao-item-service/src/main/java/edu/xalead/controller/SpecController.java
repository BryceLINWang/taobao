package edu.xalead.controller;

import edu.xalead.common.exception.SystemExceptionEnum;
import edu.xalead.common.exception.TBSystemException;
import edu.xalead.item.entity.SpecGroup;
import edu.xalead.item.entity.SpecParam;
import edu.xalead.service.SpecGroupService;
import edu.xalead.service.SpecParamService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("spec")
public class SpecController {
    @Resource
    private SpecGroupService specGroupService;
    @Resource
    private SpecParamService specParamService;
    @GetMapping("groups/{cid}")
    public ResponseEntity<List<SpecGroup>> group(@PathVariable("cid") Long cid){
        List<SpecGroup> groups = specGroupService.specGroupPage(cid);
        if(groups == null || groups.size() == 0){
            throw new TBSystemException(SystemExceptionEnum.SPEC_GROUP_NOT_FOUND);
        }
        return ResponseEntity.ok(groups);
    }
    @GetMapping("params")
    public ResponseEntity<List<SpecParam>> params(Long gid){
        List<SpecParam> params = specParamService.selectParamsByGid(gid);
        if(params == null || params.size() == 0){
            throw new TBSystemException(SystemExceptionEnum.SPEC_PARAM_NOT_FOUND);
        }
        return ResponseEntity.ok(params);
    }
}
