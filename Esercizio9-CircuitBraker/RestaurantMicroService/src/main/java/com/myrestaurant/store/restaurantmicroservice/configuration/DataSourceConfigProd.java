package com.myrestaurant.store.restaurantmicroservice.configuration;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("prod")
public class DataSourceConfigProd {
    public DataSourceConfigProd(){
        System.out.println("I am into DataSourceConfigProd class!");
    }
}
