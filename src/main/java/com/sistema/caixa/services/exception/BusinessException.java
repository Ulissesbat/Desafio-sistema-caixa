package com.sistema.caixa.services.exception;

public class BusinessException extends RuntimeException{

    public BusinessException(String msg){
        super(msg);
    }
}
