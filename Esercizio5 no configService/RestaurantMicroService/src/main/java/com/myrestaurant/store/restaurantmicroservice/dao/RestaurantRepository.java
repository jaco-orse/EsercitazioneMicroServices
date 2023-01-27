package com.myrestaurant.store.restaurantmicroservice.dao;

import com.myrestaurant.store.restaurantmicroservice.model.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RestaurantRepository extends JpaRepository<Restaurant,Long> {
}
