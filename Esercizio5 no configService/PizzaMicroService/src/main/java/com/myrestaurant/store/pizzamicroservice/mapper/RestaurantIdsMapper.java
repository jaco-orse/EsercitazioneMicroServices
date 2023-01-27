package com.myrestaurant.store.pizzamicroservice.mapper;

import com.myrestaurant.store.pizzamicroservice.dto.RestaurantIdsDTO;
import com.myrestaurant.store.pizzamicroservice.model.RestaurantIds;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RestaurantIdsMapper extends GenericMapper<RestaurantIds, RestaurantIdsDTO> {
}
