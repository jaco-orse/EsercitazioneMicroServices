package com.myrestaurant.store.NotificationService.listener.impl;

import com.myrestaurant.store.NotificationService.listener.NotificationListener;
import com.myrestaurant.store.NotificationService.service.EmailService;
import com.myrestaurant.store.NotificationService.service.SMSService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Slf4j // permette di configurare il logger
@RequiredArgsConstructor
@Profile("sms") //serve per indicare i profili che chiameranno questa implementazione ( in questo caso sms )
public class SMSListenerImpl implements NotificationListener {

    private final SMSService smsService;

    @Override
    @RabbitListener(queues = {"${app.rabbitmq.notify-pizzas-added-to-restaurant-routingkey}"})
    public void onAddPizzasToRestaurant(String message){
        log.info("Into onAddPizzasToRestaurant method.");
        smsService.sendMessage(message);
    }

}
