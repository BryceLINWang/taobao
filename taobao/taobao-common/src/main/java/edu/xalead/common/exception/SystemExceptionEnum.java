package edu.xalead.common.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.apache.http.HttpStatus;

@AllArgsConstructor
public enum SystemExceptionEnum {
    ITEM_NOT_FOUND_EXCEPTION(HttpStatus.SC_NOT_FOUND,"查找失败"),
    DEFAULT_EXCEPTION(HttpStatus.SC_OK,"商城系统异常"),
    ADD_FAIL_EXCEPTION(HttpStatus.SC_INTERNAL_SERVER_ERROR,"添加异常"),
    NOT_SELECTED_CATEGORY(HttpStatus.SC_INTERNAL_SERVER_ERROR, "未选择品牌异常");
    ;
    private int statusCode;
    private String message;

    public int getStatusCode() {
        return statusCode;
    }


    public String getMessage() {
        return message;
    }


}
