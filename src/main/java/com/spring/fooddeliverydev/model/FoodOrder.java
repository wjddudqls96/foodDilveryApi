package com.spring.fooddeliverydev.model;

import com.spring.fooddeliverydev.dto.FoodOrderDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@NoArgsConstructor
public class FoodOrder {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;


    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private int quantity;

    @Column(nullable = false)
    private int price;

    public FoodOrder(FoodOrderDto foodOrderDto){
        if(foodOrderDto.getQuantity() < 1 || foodOrderDto.getQuantity()>100){
            throw new IllegalArgumentException("음식을 주문할 수량이 이상합니다.");
        }
        this.name = foodOrderDto.getName();
        this.quantity = foodOrderDto.getQuantity();
        this.price = foodOrderDto.getPrice();
    }
}
