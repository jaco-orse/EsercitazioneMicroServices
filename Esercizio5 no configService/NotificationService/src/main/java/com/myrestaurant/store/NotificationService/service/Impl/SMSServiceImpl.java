package com.myrestaurant.store.NotificationService.service.Impl;

import com.myrestaurant.store.NotificationService.service.SMSService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class SMSServiceImpl implements SMSService {
    @Override
    public void sendMessage(String messagge) {
        log.info("SMS message : {} .", messagge);

    }
}
