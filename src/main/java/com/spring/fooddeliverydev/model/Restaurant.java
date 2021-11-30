package com.spring.fooddeliverydev.model;

import com.spring.fooddeliverydev.dto.RestaurantDto;
import com.spring.fooddeliverydev.validator.RestaurantValidator;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@Entity
@NoArgsConstructor
public class Restaurant {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;
    // 반드시 값을 가지도록 합니다.
    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private Long minOrderPrice;

    @Column(nullable = false)
    private Long deliveryFee;

    public Restaurant(RestaurantDto restaurantDto){

        RestaurantValidator.validateRestaurantInput(restaurantDto);

        this.name = restaurantDto.getName();
        this.minOrderPrice = restaurantDto.getMinOrderPrice();
        this.deliveryFee = restaurantDto.getDeliveryFee();
    }
}
