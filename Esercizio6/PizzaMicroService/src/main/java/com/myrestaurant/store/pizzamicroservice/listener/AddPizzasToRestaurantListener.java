package com.myrestaurant.store.pizzamicroservice.listener;

import com.myrestaurant.store.pizzamicroservice.dto.RestaurantIdsDTO;
import com.myrestaurant.store.pizzamicroservice.mapper.PizzaMapper;
import com.myrestaurant.store.pizzamicroservice.mapper.RestaurantIdsMapper;
import com.myrestaurant.store.pizzamicroservice.service.PizzaService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@Slf4j
@RequiredArgsConstructor
public class AddPizzasToRestaurantListener {

    private final PizzaService pizzaService;
    private final RestaurantIdsMapper restaurantIdsMapper;

    @RabbitListener(queues = {"${app.rabbitmq.add-pizzas-routingkey}"})
    public void addPizzasToRestaurant(List<RestaurantIdsDTO> restaurantIdsDTOList){
        pizzaService.addPizzasToRestaurant(restaurantIdsMapper.asEntityList(restaurantIdsDTOList));
    }

}
