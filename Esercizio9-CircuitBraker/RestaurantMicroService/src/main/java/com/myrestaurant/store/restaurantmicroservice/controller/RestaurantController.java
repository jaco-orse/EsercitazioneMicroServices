package com.myrestaurant.store.restaurantmicroservice.controller;


import com.myrestaurant.store.restaurantmicroservice.dto.RestaurantDTO;
import com.myrestaurant.store.restaurantmicroservice.dto.RestaurantIdsDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Api(tags = "Restaurant API") //tag di swagger
public interface RestaurantController {


    @ApiOperation("add Pizza to Restaurant")
    public ResponseEntity<?> addPizzaToRestaurant(@RequestBody List<RestaurantIdsDTO> restaurantIdsDTOS);
    //List<RestaurantIdsDTO> è una lista di elementi con id_ristorante e id_pizza

    @ApiOperation("Find all pizzas by restaurant id")
    public ResponseEntity<?> getPizzasByRestaurant(@PathVariable("id") Long restaurantId);

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
