package com.myrestaurant.store.pizzarestaurantservice.controller.impl;

import com.myrestaurant.store.pizzarestaurantservice.controller.RestaurantController;
import com.myrestaurant.store.pizzarestaurantservice.dto.PizzaDTO;
import com.myrestaurant.store.pizzarestaurantservice.dto.RestaurantDTO;
import com.myrestaurant.store.pizzarestaurantservice.mapper.RestaurantMapper;
import com.myrestaurant.store.pizzarestaurantservice.model.Restaurant;
import com.myrestaurant.store.pizzarestaurantservice.service.RestaurantService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/restaurants")
@RequiredArgsConstructor
public class RestaurantControllerImpl implements RestaurantController {

    private final RestaurantMapper restaurantMapper;
    private final RestaurantService restaurantService;

    @Override
    @PostMapping("/addPizzas")
    @ResponseStatus(HttpStatus.CREATED)
    public RestaurantDTO addPizzasToRestaurant(@RequestBody RestaurantDTO rDTO){
        Restaurant restaurant = restaurantMapper.asEntity(rDTO);
        return restaurantMapper.asDTO(restaurantService.addPizzasToRestaurant(restaurant));
    }

    @Override
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public RestaurantDTO save(RestaurantDTO restaurantDTO) {
        Restaurant r = restaurantMapper.asEntity(restaurantDTO);
        return restaurantMapper.asDTO(restaurantService.save(r));
    }

    @Override
    @GetMapping("/{id}")
    public RestaurantDTO findById(Long id) {
        Restaurant r = restaurantService.findById(id).orElse(null);
        return restaurantMapper.asDTO(r);
    }

    @Override
    @DeleteMapping("/{id}")
    public void deleteById(Long id) {
        restaurantService.deleteById(id);
    }

    @Override
    @GetMapping
    public List<RestaurantDTO> list() {
        return restaurantMapper.asDTOList(restaurantService.findAll());
    }

    @Override
    @PutMapping("/{id}")
    public RestaurantDTO update(Long id, RestaurantDTO rDTO) {
        Restaurant r = restaurantMapper.asEntity(rDTO);
        return restaurantMapper.asDTO(restaurantService.update(r,id));
    }
}
