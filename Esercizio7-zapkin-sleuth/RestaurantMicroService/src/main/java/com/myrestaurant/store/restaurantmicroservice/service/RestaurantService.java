package com.myrestaurant.store.restaurantmicroservice.service;


import com.myrestaurant.store.restaurantmicroservice.dto.RestaurantIdsDTO;
import com.myrestaurant.store.restaurantmicroservice.model.Restaurant;

import java.util.List;

public interface RestaurantService extends GenericService<Restaurant,Long> {

    public void addPizzasToRestaurant(List<RestaurantIdsDTO> restaurantIdsDTOS);
}
