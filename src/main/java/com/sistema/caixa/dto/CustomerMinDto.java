package com.sistema.caixa.dto;

import com.sistema.caixa.projection.CustomerMinProjection;


public class CustomerMinDto {

    private String name;

    public CustomerMinDto() {
    }
    public CustomerMinDto(CustomerMinProjection projection) {
        this.name = projection.getNome();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
