package com.myrestaurant.store.restaurantmicroservice.controller.impl;


import com.myrestaurant.store.restaurantmicroservice.controller.RestaurantController;
import com.myrestaurant.store.restaurantmicroservice.dto.RestaurantDTO;
import com.myrestaurant.store.restaurantmicroservice.dto.RestaurantIdsDTO;
import com.myrestaurant.store.restaurantmicroservice.mapper.RestaurantMapper;
import com.myrestaurant.store.restaurantmicroservice.model.Restaurant;
import com.myrestaurant.store.restaurantmicroservice.service.RestaurantService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/restaurants")
@RequiredArgsConstructor
public class RestaurantControllerImpl implements RestaurantController {

    private final RestaurantMapper restaurantMapper;
    private final RestaurantService restaurantService;

    @Value("${app.pizza-service-url}")
    private String pizzaServiceUrl;
    //private String pizzaServiceUrl = "http://localhost:9090/api/pizzas/restaurant";
    // meglio aggiungere l'url nel properties.yaml

    @Override
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("addPizzas")
    public List<Object> addPizzaToRestaurant(@RequestBody List<RestaurantIdsDTO> restaurantIdsDTOS){
        RestTemplate restTemplate = new RestTemplate();
        return List.of(Objects.requireNonNull(restTemplate.postForObject(pizzaServiceUrl, restaurantIdsDTOS , Object[].class)));
    }

    @Override
    @GetMapping("/pizzas/{id}")
    public List<Object> getPizzasByRestaurant(@PathVariable("id") Long restaurantId) {
        RestTemplate restTemplate = new RestTemplate();
        return List.of(Objects.requireNonNull(restTemplate.getForObject(pizzaServiceUrl + "/" + restaurantId, Object[].class)));
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
