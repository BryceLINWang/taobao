package edu.xalead.exception;

public class TBSystemException extends RuntimeException {
     public TBSystemException(){
         super("商品系统异常");
     }
    public TBSystemException(String mesg){
        super(mesg);
    }
}
