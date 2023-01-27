package com.myrestaurant.store.pizzamicroservice.dao;

import com.myrestaurant.store.pizzamicroservice.model.Pizza;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PizzaRepository extends JpaRepository<Pizza,Long> {

}
