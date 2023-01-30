package com.myrestaurant.store.restaurantmicroservice.configuration;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("dev")
public class DataSourceConfigDev {

    public DataSourceConfigDev(){
        System.out.println("I am into DataSourceConfigDev class!");
    }

}
