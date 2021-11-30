package com.spring.fooddeliverydev.dto;


import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class FoodOrderRequestDto {
    Long id;
    int quantity;
}
