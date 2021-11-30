package com.spring.fooddeliverydev.mapping;

import com.spring.fooddeliverydev.model.FoodOrder;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.OneToMany;
import java.util.List;

public interface OrderModelMapping {
    String getRestaurantName();
    List<FoodMapping> getFoods();
    int getDeliveryFee();
    int getTotalPrice();
}
