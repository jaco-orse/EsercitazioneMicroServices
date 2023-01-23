package com.myrestaurant.store.pizzarestaurantservice.controller;

import com.myrestaurant.store.pizzarestaurantservice.dto.PizzaDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Api(tags = "Pizza API") //tag di swagger
public interface PizzaController {
    @ApiOperation("Add new pizza") //tag di swagger
    public PizzaDTO save(@RequestBody PizzaDTO pizzaDTO);

    @ApiOperation("Find pizza by Id")
    public PizzaDTO findById(@PathVariable("id") Long id);

    @ApiOperation("Delete pizza by Id")
    public void deleteById(@PathVariable("id") Long id);

    @ApiOperation("Find all pizzas")
    public List<PizzaDTO> list();

    @ApiOperation("Update pizza by Id")
    public PizzaDTO update(@PathVariable("id") Long id, @RequestBody PizzaDTO pizzaDTO);

}
