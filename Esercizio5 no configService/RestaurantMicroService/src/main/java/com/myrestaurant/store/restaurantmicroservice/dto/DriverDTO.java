package com.myrestaurant.store.restaurantmicroservice.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder
public class DriverDTO {

    private Long id;
    private String name;

    //private Set<RestaurantDTO> restaurants = new HashSet<>();
}
