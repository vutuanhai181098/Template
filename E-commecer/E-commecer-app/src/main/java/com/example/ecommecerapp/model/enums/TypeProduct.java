package com.example.ecommecerapp.model.enums;

import lombok.Getter;

@Getter
public enum TypeProduct {
    SHIRT("Áo"), PANT("Quần"), UNDERWEAR("Đồ lót");

    private final String value;

    TypeProduct(String value){
        this.value = value;
    }
}
