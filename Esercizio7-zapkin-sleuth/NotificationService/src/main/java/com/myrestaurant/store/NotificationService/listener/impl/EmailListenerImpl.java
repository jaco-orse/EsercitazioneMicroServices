package com.myrestaurant.store.NotificationService.listener.impl;

import com.myrestaurant.store.NotificationService.listener.NotificationListener;
import com.myrestaurant.store.NotificationService.service.EmailService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Slf4j // permette di configurare il logger
@RequiredArgsConstructor
@Profile("email") //serve per indicare i profili che chiameranno questa implementazione ( in questo caso email )
public class EmailListenerImpl implements NotificationListener {

    private final EmailService emailService;

    @Override
    @RabbitListener(queues = {"${app.rabbitmq.notify-pizzas-added-to-restaurant-routingkey}"})
    public void onAddPizzasToRestaurant(String message){
        log.info("Into onAddPizzasToRestaurant method.");
        emailService.sendMessage(message);
    }

}