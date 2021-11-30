package com.spring.fooddeliverydev.model;

import com.spring.fooddeliverydev.dto.FoodDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@NoArgsConstructor
public class Food {
    @GeneratedValue(strategy = GenerationType.AUTO)
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
        this.name = foodDto.getName();
        this.price = foodDto.getPrice();
        this.restaurant = restaurant;
    }
}
