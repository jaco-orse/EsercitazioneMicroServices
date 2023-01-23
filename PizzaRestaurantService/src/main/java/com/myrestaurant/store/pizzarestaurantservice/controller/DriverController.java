package com.myrestaurant.store.pizzarestaurantservice.controller;

import com.myrestaurant.store.pizzarestaurantservice.dto.DriverDTO;
import com.myrestaurant.store.pizzarestaurantservice.dto.RestaurantDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Api(tags = "Driver API") //tag di swagger
public interface DriverController {

    @ApiOperation("Add new driver") //tag di swagger
    public DriverDTO save(@RequestBody DriverDTO dDTO);

    @ApiOperation("Find driver by Id")
    public DriverDTO findById(@PathVariable("id") Long id);

    @ApiOperation("Delete driver by Id")
    public void deleteById(@PathVariable("id") Long id);

    @ApiOperation("Find all drivers")
    public List<DriverDTO> list();

    @ApiOperation("Update driver by Id")
    public DriverDTO update(@PathVariable("id") Long id, @RequestBody DriverDTO dDTO);
}
