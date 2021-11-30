package com.spring.fooddeliverydev.repository;

import com.spring.fooddeliverydev.model.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RestaurantRepository extends JpaRepository<Restaurant,Long> {
}
