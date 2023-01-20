package com.myrestaurant.store.pizzarestaurantservice;

import com.myrestaurant.store.pizzarestaurantservice.DAO.PizzaRepository;
import com.myrestaurant.store.pizzarestaurantservice.model.Pizza;
import com.myrestaurant.store.pizzarestaurantservice.model.Topping;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Set;

@SpringBootTest
class PizzaRestaurantServiceApplicationTests {

    @Autowired
    PizzaRepository pizzaRepository;



    @Test
    void populateDB() {

        //Topping mozzarella = new Topping();
        Topping mozzarella = Topping.builder()
                .name("Mozzarella locale")
                .build();

        Topping pomodoro = Topping.builder()
                .name("Pomodoro")
                .build();

        Topping basilico = Topping.builder()
                .name("Basilico")
                .build();

        Pizza margherita = Pizza.builder()
                .name("Margherita")
                .favorite(true)
                .toppings(Set.of(mozzarella,pomodoro,basilico))
                .build();

        pizzaRepository.saveAll(
                List.of(margherita)
        );
    }

}
