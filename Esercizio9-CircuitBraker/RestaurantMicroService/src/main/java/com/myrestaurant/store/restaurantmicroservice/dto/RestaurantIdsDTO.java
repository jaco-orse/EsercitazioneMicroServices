package com.myrestaurant.store.restaurantmicroservice.dto;

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
