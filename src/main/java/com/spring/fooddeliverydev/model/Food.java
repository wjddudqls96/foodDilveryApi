package com.spring.fooddeliverydev.model;

import com.spring.fooddeliverydev.dto.FoodDto;
import com.spring.fooddeliverydev.validator.FoodValidator;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@SequenceGenerator(
        name = "FOOD_SEQ_GENERATOR",
        sequenceName = "FOOD_SEQ", // 매핑할 데이터베이스 시퀀스 이름
        initialValue = 1,
        allocationSize = 1)
@NoArgsConstructor
public class Food {
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "FOOD_SEQ_GENERATOR")
    @Id
    private Long id;
    // 반드시 값을 가지도록 합니다.
    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private Long price;

    @ManyToOne
    @JoinColumn(name = "RESTAURANT_ID", nullable = false)
    private Restaurant restaurant;

    public Food(Restaurant restaurant, FoodDto foodDto){
        FoodValidator.validateFoodInput(foodDto);
        this.name = foodDto.getName();
        this.price = foodDto.getPrice();
        this.restaurant = restaurant;
    }
}
