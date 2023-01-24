package com.myrestaurant.store.restaurantmicroservice.dao;

import com.myrestaurant.store.restaurantmicroservice.model.Driver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DriverRepository extends JpaRepository<Driver,Long> {
}
