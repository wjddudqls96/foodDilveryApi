package com.spring.fooddeliverydev.controller;


import com.spring.fooddeliverydev.dto.FoodOrderDto;
import com.spring.fooddeliverydev.dto.FoodOrderRequestDto;
import com.spring.fooddeliverydev.dto.OrderDto;
import com.spring.fooddeliverydev.dto.OrderRequestDto;
import com.spring.fooddeliverydev.model.Food;
import com.spring.fooddeliverydev.model.FoodOrder;
import com.spring.fooddeliverydev.model.OrderModel;
import com.spring.fooddeliverydev.model.Restaurant;
import com.spring.fooddeliverydev.repository.FoodOrderRepository;
import com.spring.fooddeliverydev.repository.FoodRepository;
import com.spring.fooddeliverydev.repository.OrderRepository;
import com.spring.fooddeliverydev.repository.RestaurantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.criteria.Order;
import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@RestController
public class OrderController {
    private final RestaurantRepository restaurantRepository;
    private final FoodRepository foodRepository;
    private final OrderRepository orderRepository;
    private final FoodOrderRepository foodOrderRepository;

    @PostMapping("/order/request")
    public OrderModel orderRegister(@RequestBody OrderRequestDto orderRequestDto){
        //레스토랑 찾기
        Restaurant restaurant = restaurantRepository.findById(orderRequestDto.getRestaurantId()).orElse(null);
        List<FoodOrderDto> foodOrderDtoList = new ArrayList<>();
        int sum = 0;
        for (FoodOrderRequestDto foodOrderRequestDto: orderRequestDto.getFoods()) {
            Food food = foodRepository.findById(foodOrderRequestDto.getId()).orElse(null);
            String foodName = food.getName();
            int foodPrice = Math.toIntExact(food.getPrice());

            FoodOrderDto foodOrderDto = new FoodOrderDto(foodName,foodOrderRequestDto.getQuantity(),foodPrice*foodOrderRequestDto.getQuantity());
            sum += (foodPrice*foodOrderRequestDto.getQuantity());
            FoodOrder foodOrder = new FoodOrder(foodOrderDto);
            foodOrderRepository.save(foodOrder);
            foodOrderDtoList.add(foodOrderDto);
        }
        System.out.println(restaurant.getName());
//        sum += restaurant.getDeliveryFee();
        OrderDto orderDto = new OrderDto(restaurant.getName(),foodOrderDtoList, Math.toIntExact(restaurant.getDeliveryFee()),sum);
        OrderModel order = new OrderModel(orderDto,restaurant.getMinOrderPrice());
        orderRepository.save(order);
        return order;
    }

    @GetMapping("/orders")
    public List<OrderModel> getOrder(){
        return orderRepository.findAll();
    }

}
