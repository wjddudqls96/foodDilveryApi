package com.spring.fooddeliverydev.model;

import com.spring.fooddeliverydev.dto.FoodOrderDto;
import com.spring.fooddeliverydev.dto.OrderDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@NoArgsConstructor
public class OrderModel {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;

    @Column(nullable = false)
    private String restaurantName;

    @OneToMany(cascade = CascadeType.ALL)
    @Column(nullable = false)
    private List<FoodOrder> foods;

    @Column(nullable = false)
    private int deliveryFee;

    @Column(nullable = false)
    private int totalPrice;

    public OrderModel(OrderDto orderDto){
        if(orderDto.getMinOrderPrice() > orderDto.getTotalPrice()){
            throw new IllegalArgumentException("최소주문 가격이 더 높습니다.");
        }
        List<FoodOrder> changefoods = new ArrayList<>();
        for (FoodOrderDto foodOrderDto: orderDto.getFoods()) {
            FoodOrder foodOrder = new FoodOrder(foodOrderDto);
            changefoods.add(foodOrder);
        }
        this.restaurantName = orderDto.getRestaurantName();
        this.foods = changefoods;
        this.deliveryFee = orderDto.getDeliveryFee();
        this.totalPrice = orderDto.getTotalPrice()+ orderDto.getDeliveryFee();
    }
}
