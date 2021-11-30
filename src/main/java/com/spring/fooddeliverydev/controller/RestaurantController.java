package com.spring.fooddeliverydev.controller;

import com.spring.fooddeliverydev.dto.RestaurantDto;
import com.spring.fooddeliverydev.model.Restaurant;
import com.spring.fooddeliverydev.service.RestaurantService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class RestaurantController {
    private final RestaurantService restaurantService;

    @PostMapping("/restaurant/register")
    public Restaurant saveComments(@RequestBody RestaurantDto restaurantDto){
        return restaurantService.registerRestaurant(restaurantDto);
    }

    @GetMapping("/restaurants")
    public List<Restaurant> getListRestaurants(){
        return restaurantService.serviceGetListRestaurant();
    }
}
