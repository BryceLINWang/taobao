package edu.xalead;

import edu.xalead.entity.Item;
import edu.xalead.service.ItemService;
import edu.xalead.taobao.common.exception.CommonExceptionAdvice.TaobaoItemException;
import edu.xalead.taobao.common.exception.CommonExceptionAdvice.TaobaoItemExceptionEnum;
import org.apache.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("item")
public class ItemController {
    @Resource
    private ItemService itemService;
    @PostMapping("saveItem")
    public ResponseEntity<Item> saveItem(Item item){
        if(item.getName() == null){
            throw new TaobaoItemException(TaobaoItemExceptionEnum.EXCEPTION_ENUM_BAD_ARGS);
        }
        item = itemService.saveItem(item);
        return ResponseEntity.status(HttpStatus.SC_OK).body(item);
    }
}
