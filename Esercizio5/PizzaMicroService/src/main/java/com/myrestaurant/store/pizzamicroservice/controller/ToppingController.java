package com.myrestaurant.store.pizzamicroservice.controller;

import com.myrestaurant.store.pizzamicroservice.dto.ToppingDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Api(tags = "Topping API") //tag di swagger
public interface ToppingController {

    @ApiOperation("Add new topping")
    public ToppingDTO save(@RequestBody ToppingDTO topping);

    @ApiOperation("Find topping by Id")
    public ToppingDTO findById(@PathVariable("id") Long id);

    @ApiOperation("Delete topping by Id")
    public void deleteById(@PathVariable("id") Long id);

    @ApiOperation("Find all toppings")
    public List<ToppingDTO> list();

    @ApiOperation("Update topping by Id")
    public ToppingDTO update(@PathVariable("id") Long id, @RequestBody ToppingDTO topping);

}
