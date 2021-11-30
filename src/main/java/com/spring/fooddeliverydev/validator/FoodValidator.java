package com.spring.fooddeliverydev.validator;

import com.spring.fooddeliverydev.dto.FoodDto;
import com.spring.fooddeliverydev.dto.RestaurantDto;

public class FoodValidator {
    public static void validateFoodInput(FoodDto foodDto){
        if(foodDto.getPrice() < 100 || foodDto.getPrice()>1_000_000){
            throw new IllegalArgumentException("가격 허용값이 벗어났습니다.");
        }
        if(foodDto.getPrice()%100 !=0){
            throw new IllegalArgumentException("가격 단위가 안맞습니다.");
        }
    }
}
