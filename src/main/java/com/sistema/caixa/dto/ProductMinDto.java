package com.sistema.caixa.dto;

import com.sistema.caixa.projection.ProductMinProjection;


public class ProductMinDto {

    private String name;

    public ProductMinDto() {
    }
    public ProductMinDto(ProductMinProjection projection) {

        this.name = projection.getNome();
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {

        this.name = name;
    }
}
