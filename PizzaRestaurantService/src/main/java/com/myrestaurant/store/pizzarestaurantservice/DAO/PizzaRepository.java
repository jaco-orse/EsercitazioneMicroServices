package com.myrestaurant.store.pizzarestaurantservice.DAO;

import com.myrestaurant.store.pizzarestaurantservice.model.Pizza;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PizzaRepository extends JpaRepository<Pizza,Long> {
}
