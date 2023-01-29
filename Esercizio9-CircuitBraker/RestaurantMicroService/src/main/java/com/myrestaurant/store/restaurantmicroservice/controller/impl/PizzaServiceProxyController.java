package com.myrestaurant.store.restaurantmicroservice.controller.impl;

import com.myrestaurant.store.restaurantmicroservice.dto.RestaurantIdsDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Component
@FeignClient(name = "PIZZA-SERVICE")
public interface PizzaServiceProxyController {


    @PostMapping(value = "/api/pizzas/restaurant")
    public List<Object> addPizzasToRestaurant(List<RestaurantIdsDTO> restaurantIdsDTOS);

    @GetMapping(value = "/api/pizzas/restaurant/{id}")
    public List<Object> findPizzaByRestaurant(@PathVariable("id") Long restaurantId);


}
