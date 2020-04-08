package edu.xalead.common.exception;

import lombok.Data;

@Data
public class TBSystemException extends RuntimeException {
    private int statusCode;
     public TBSystemException(){
         super("商品系统异常");
         this.statusCode=400;
     }
    public TBSystemException(String mesg,int statusCode){
         super(mesg);
         this.statusCode=statusCode;
    }

    public TBSystemException(SystemExceptionEnum exceptionEnum) {
         super(exceptionEnum.getMessage());
         this.statusCode=exceptionEnum.getStatusCode();
    }
}
