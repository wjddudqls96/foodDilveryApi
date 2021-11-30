package com.spring.fooddeliverydev.repository;

import com.spring.fooddeliverydev.model.Food;
import com.spring.fooddeliverydev.model.FoodOrder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FoodOrderRepository extends JpaRepository<FoodOrder,Long> {
}
