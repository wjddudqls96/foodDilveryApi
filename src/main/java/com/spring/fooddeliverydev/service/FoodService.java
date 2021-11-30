package com.spring.fooddeliverydev.service;

import com.spring.fooddeliverydev.dto.FoodDto;
import com.spring.fooddeliverydev.mapping.FoodMapping;
import com.spring.fooddeliverydev.model.Food;
import com.spring.fooddeliverydev.model.Restaurant;
import com.spring.fooddeliverydev.repository.FoodRepository;
import com.spring.fooddeliverydev.repository.RestaurantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class FoodService {
    private final FoodRepository foodRepository;
    private final RestaurantRepository restaurantRepository;

    public void serviceRegisterFood(Long restaurantId,List<FoodDto> foodDtoList){
        List<Food> foodList = new ArrayList<>();
        Restaurant restaurant = restaurantRepository.findById(restaurantId).orElse(null);
        for (FoodDto foodDto:foodDtoList) {
            Food food = new Food(restaurant,foodDto);
            Optional<Food> found = foodRepository.findByName(food.getName());
            if(found.isPresent()){
                throw new IllegalArgumentException("중복된 이름의 음식이 존재합니다.");
            }
            foodList.add(food);
        }

        for (Food food : foodList) {
            foodRepository.save(food);
        }
    }

    public List<FoodMapping> serviceGetRestaurantFoods(Long restaurantId){
        Restaurant restaurant = restaurantRepository.findById(restaurantId).orElse(null);
        List<FoodMapping> foodList = foodRepository.findAllByRestaurant(restaurant);

        return  foodList;
    }
}
