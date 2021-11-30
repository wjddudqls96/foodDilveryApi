package com.spring.fooddeliverydev.service;

import com.spring.fooddeliverydev.dto.RestaurantDto;
import com.spring.fooddeliverydev.model.Restaurant;
import com.spring.fooddeliverydev.repository.RestaurantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class RestaurantService {
    private  final RestaurantRepository repository;

    public Restaurant registerRestaurant(RestaurantDto restaurantDto){
        Restaurant restaurant = new Restaurant(restaurantDto);
        repository.save(restaurant);
        return restaurant;
    }

    public List<Restaurant> serviceGetListRestaurant(){
        return repository.findAll();
    }
}
