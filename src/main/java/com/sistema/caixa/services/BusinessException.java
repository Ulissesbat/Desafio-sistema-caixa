package com.sistema.caixa.services;

public class BusinessException extends RuntimeException{

    public BusinessException(String msg){
        super(msg);
    }
}
