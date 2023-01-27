package com.myrestaurant.store.pizzamicroservice.mapper;

import com.myrestaurant.store.pizzamicroservice.dto.ToppingDTO;
import com.myrestaurant.store.pizzamicroservice.model.Topping;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ToppingMapper extends GenericMapper<Topping, ToppingDTO> {
}
