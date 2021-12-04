package com.spring.fooddeliverydev.service;

import com.spring.fooddeliverydev.dto.FoodDto;
import com.spring.fooddeliverydev.mapping.FoodMapping;
import com.spring.fooddeliverydev.model.Food;
import com.spring.fooddeliverydev.model.Restaurant;
import com.spring.fooddeliverydev.repository.FoodRepository;
import com.spring.fooddeliverydev.repository.RestaurantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

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
        List<String> foodNameList = new ArrayList<>();

        Restaurant restaurant = restaurantRepository.findById(restaurantId).orElse(null);
        if(restaurant == null){
            throw new IllegalArgumentException("해당되는 음식점이 없습니다.");
        }
        for (FoodDto foodDto:foodDtoList) {
            Food food = new Food(restaurant,foodDto);

            Optional<Food> found = foodRepository.findByNameAndRestaurant(food.getName(),restaurant);
            if(found.isPresent()){
                throw new IllegalArgumentException("중복된 이름의 음식이 존재합니다.");
            }
            if(foodNameList.contains(food.getName())){
                throw new IllegalArgumentException("중복된 이름의 음식이 존재합니다.");
            }
            foodNameList.add(food.getName());
            foodList.add(food);
        }

        for (Food food : foodList) {
            foodRepository.save(food);
        }
    }

    public List<Food> serviceGetRestaurantFoods(Long restaurantId){
        Restaurant restaurant = restaurantRepository.findById(restaurantId).orElse(null);
        List<Food> foodList = foodRepository.findAllByRestaurant(restaurant);
        return  foodList;
    }
}
