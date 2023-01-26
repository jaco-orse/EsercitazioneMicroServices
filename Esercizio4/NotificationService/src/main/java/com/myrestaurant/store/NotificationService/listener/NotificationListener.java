package com.myrestaurant.store.NotificationService.listener;

import com.myrestaurant.store.NotificationService.service.EmailService;
import com.myrestaurant.store.NotificationService.service.SMSService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j // permette di configurare il logger
@RequiredArgsConstructor
public class NotificationListener {

    private final EmailService emailService;
    private final SMSService smsService;

    /*
    @RabbitListener(queues = {"${app.rabbitmq.pizzas-added-routingkey}"})
    public void onAddPizzasToRestaurant(String event){
        log.info("Into onAddPizzasToRestaurant method.");
        emailService.sendMessage(event);
        smsService.sendMessage(event);
    }
    */

    @RabbitListener(queues = {"${app.rabbitmq.notify-pizzas-added-to-restaurant-routingkey}"})
    public void onAddPizzasToRestaurant(String message){
        log.info("Into onAddPizzasToRestaurant method.");
        //String event = "Added n." + pizzas.size() + "pizzas.";
        String event = message;
        emailService.sendMessage(event);
        smsService.sendMessage(event);
    }
}
