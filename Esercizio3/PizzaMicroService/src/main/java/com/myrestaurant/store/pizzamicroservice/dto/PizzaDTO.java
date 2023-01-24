package com.myrestaurant.store.pizzamicroservice.dto;

import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder
public class PizzaDTO {

    private Long id;
    private String name;
    private boolean favorite;
    private Set<ToppingDTO> toppings = new HashSet<ToppingDTO>();

}
