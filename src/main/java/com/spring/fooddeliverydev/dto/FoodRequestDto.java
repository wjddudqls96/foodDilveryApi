package com.spring.fooddeliverydev.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FoodRequestDto {
    private Long restaurantId;
    private  String name;

    public FoodRequestDto(Long restaurantId, String name){
        this.restaurantId = restaurantId;
        this.name = name;
    }
}
