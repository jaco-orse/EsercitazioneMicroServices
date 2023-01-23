package com.myrestaurant.store.pizzarestaurantservice.service;

import com.myrestaurant.store.pizzarestaurantservice.model.Restaurant;

public interface RestaurantService extends GenericService<Restaurant,Long> {

    Restaurant addPizzasToRestaurant(Restaurant r);
}
