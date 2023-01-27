package com.myrestaurant.store.NotificationService.service.Impl;

import com.myrestaurant.store.NotificationService.service.EmailService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class EmailServiceImpl implements EmailService {
    @Override
    public void sendMessage(String messagge) {
        log.info("Email message : {} .", messagge);
    }
}
