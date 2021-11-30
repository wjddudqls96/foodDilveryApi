package com.spring.fooddeliverydev.dto;

import lombok.Getter;

@Getter
public class FoodOrderDto {
    private String name;
    private int quantity;
    private int price;

    public FoodOrderDto(String name, int quantity, int price){
        this.name = name;
        this.quantity = quantity;
        this.price =price;
    }
}
