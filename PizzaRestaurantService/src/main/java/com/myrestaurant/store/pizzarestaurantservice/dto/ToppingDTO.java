package com.myrestaurant.store.pizzarestaurantservice.dto;

import com.myrestaurant.store.pizzarestaurantservice.model.Pizza;
import lombok.*;

import java.util.HashSet;
import java.util.Set;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder
public class ToppingDTO {
    private Long id;
    private String name;

    // Non lo metto perchè nel progetto corrente non ci serve
    // private Set<Pizza> pizzas = new HashSet<Pizza>();

}
