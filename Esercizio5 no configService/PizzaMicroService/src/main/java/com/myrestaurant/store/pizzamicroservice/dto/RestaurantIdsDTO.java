package com.myrestaurant.store.pizzamicroservice.dto;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class RestaurantIdsDTO {

    private Long restaurantId;
    private Long pizzaId;
}
