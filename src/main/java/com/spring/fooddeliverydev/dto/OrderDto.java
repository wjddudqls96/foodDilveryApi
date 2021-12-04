package com.spring.fooddeliverydev.dto;

import com.spring.fooddeliverydev.model.Restaurant;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class OrderDto {
    private String restaurantName;
    private List<FoodOrderDto> foods;
    private int deliveryFee;
    private int totalPrice;
    private int minOrderPrice;

    public OrderDto(Restaurant restaurant, List<FoodOrderDto> foods, int sum){
        this.restaurantName = restaurant.getName();
        this.minOrderPrice = Math.toIntExact(restaurant.getMinOrderPrice());
        this.foods = foods;
        this.deliveryFee = Math.toIntExact(restaurant.getDeliveryFee());
        this.totalPrice = sum;
    }
}
