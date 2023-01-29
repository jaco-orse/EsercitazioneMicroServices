package com.myrestaurant.store.restaurantmicroservice.mapper;

import com.myrestaurant.store.restaurantmicroservice.dto.DriverDTO;
import com.myrestaurant.store.restaurantmicroservice.model.Driver;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface DriverMapper extends GenericMapper<Driver, DriverDTO> {
}
