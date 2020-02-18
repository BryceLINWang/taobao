package edu.xalead.taobao.common.exception.CommonExceptionAdvice;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public enum TaobaoItemExceptionEnum {
    EXCEPTION_ENUM_BAD_ARGS(401,"请求参数有问题！"),
    EXCEPTION_ENUM_NOT_FONUND(404,"找不到路径！");
    ;
//    TaobaoItemExceptionEnum t = new TaobaoItemExceptionEnum(222,"");
    private Integer code;
    private String mesg;
}
