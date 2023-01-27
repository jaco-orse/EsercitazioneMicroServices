package com.myrestaurant.store.pizzamicroservice.dao;

import com.myrestaurant.store.pizzamicroservice.model.Topping;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ToppingRepository extends JpaRepository<Topping,Long> {
}
