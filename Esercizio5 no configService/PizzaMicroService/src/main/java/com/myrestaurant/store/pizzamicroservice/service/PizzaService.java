package com.myrestaurant.store.pizzamicroservice.service;

import com.myrestaurant.store.pizzamicroservice.model.Pizza;
import com.myrestaurant.store.pizzamicroservice.model.RestaurantIds;

import java.util.List;

public interface PizzaService extends GenericService<Pizza,Long>{

    List<Pizza> findByRestaurantId(Long restaurantId);

    List<Pizza> addPizzasToRestaurant(List<RestaurantIds> restaurantIds);
}
