package com.myrestaurant.store.pizzarestaurantservice.controller;

import com.myrestaurant.store.pizzarestaurantservice.dto.PizzaDTO;
import com.myrestaurant.store.pizzarestaurantservice.dto.RestaurantDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Api(tags = "Restaurant API") //tag di swagger
public interface RestaurantController {
    @ApiOperation("Add new restaurant") //tag di swagger
    public RestaurantDTO save(@RequestBody RestaurantDTO restaurantDTO);

    @ApiOperation("Find restaurant by Id")
    public RestaurantDTO findById(@PathVariable("id") Long id);

    @ApiOperation("Delete restaurant by Id")
    public void deleteById(@PathVariable("id") Long id);

    @ApiOperation("Find all restaurants")
    public List<RestaurantDTO> list();

    @ApiOperation("Update pizza by Id")
    public RestaurantDTO update(@PathVariable("id") Long id, @RequestBody RestaurantDTO rDTO);

}
