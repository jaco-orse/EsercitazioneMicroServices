package com.myrestaurant.store.restaurantmicroservice.mapper;

import com.myrestaurant.store.restaurantmicroservice.dto.RestaurantDTO;
import com.myrestaurant.store.restaurantmicroservice.model.Restaurant;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RestaurantMapper extends GenericMapper<Restaurant, RestaurantDTO>{
}
