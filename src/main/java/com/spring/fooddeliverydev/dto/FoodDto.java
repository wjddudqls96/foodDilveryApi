package com.spring.fooddeliverydev.dto;

import com.spring.fooddeliverydev.model.Restaurant;
import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Getter
public class FoodDto {
    private String name;
    private Long price;
}
