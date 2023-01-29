package com.myrestaurant.store.pizzamicroservice.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;
import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Entity
@Table(name = "restaurant_ids")
@IdClass(RestaurantIdsPK.class)
public class RestaurantIds implements Serializable {

    @Id
    private Long restaurantId;
    @Id
    private Long pizzaId;

}
