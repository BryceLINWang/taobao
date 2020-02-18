package edu.xalead.taobao.common.exception.CommonExceptionAdvice;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class TaobaoItemException extends RuntimeException{
    private int code;
    private String mesg;
    public TaobaoItemException(int code, String mesg) {
        this.code = code;
        this.mesg = mesg;
    }

    public TaobaoItemException(TaobaoItemExceptionEnum e) {
        this.code = e.getCode();
        this.mesg = e.getMesg();
    }
}
