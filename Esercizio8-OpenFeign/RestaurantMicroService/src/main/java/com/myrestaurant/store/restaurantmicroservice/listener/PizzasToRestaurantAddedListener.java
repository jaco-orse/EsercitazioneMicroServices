package com.myrestaurant.store.restaurantmicroservice.listener;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class PizzasToRestaurantAddedListener {

    @RabbitListener(queues = {"${app.rabbitmq.pizzas-added-routingkey}"})
    public void onPizzasToRestaurantAdded(List<Object> pizzas){
        log.info("Restaurant Listener --> Into onPizzasToRestaurantAdded method!");
        for(Object pizza : pizzas){
            log.info("Pizza --> " + pizza.toString());
        }
    }

}
