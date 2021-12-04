package com.spring.fooddeliverydev.controller;

import com.spring.fooddeliverydev.dto.FoodDto;
import com.spring.fooddeliverydev.mapping.FoodMapping;
import com.spring.fooddeliverydev.model.Food;
import com.spring.fooddeliverydev.service.FoodService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class FoodController {
    private final FoodService foodService;

    @PostMapping("/restaurant/{restaurantId}/food/register")
    public void registerFood(@PathVariable Long restaurantId, @RequestBody List<FoodDto> foodDtoList){
        foodService.serviceRegisterFood(restaurantId,foodDtoList);
    }

    @GetMapping("/restaurant/{restaurantId}/foods")
    public List<Food> getRestaurantFoods(@PathVariable Long restaurantId){
        return foodService.serviceGetRestaurantFoods(restaurantId);
    }
}
