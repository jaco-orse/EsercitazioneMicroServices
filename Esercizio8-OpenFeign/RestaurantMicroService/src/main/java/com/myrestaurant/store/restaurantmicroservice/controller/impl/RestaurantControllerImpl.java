package com.myrestaurant.store.restaurantmicroservice.controller.impl;


import com.myrestaurant.store.restaurantmicroservice.controller.RestaurantController;
import com.myrestaurant.store.restaurantmicroservice.dto.RestaurantDTO;
import com.myrestaurant.store.restaurantmicroservice.dto.RestaurantIdsDTO;
import com.myrestaurant.store.restaurantmicroservice.mapper.RestaurantMapper;
import com.myrestaurant.store.restaurantmicroservice.model.Restaurant;
import com.myrestaurant.store.restaurantmicroservice.service.RestaurantService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.retry.annotation.Retryable;
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

    private final PizzaServiceProxyController pizzaServiceProxyController;
    @Value("${app.pizza-service-url}")
    private String pizzaServiceUrl;




    @Override
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("addPizzas")
    public List<Object> addPizzaToRestaurant(@RequestBody List<RestaurantIdsDTO> restaurantIdsDTOS){
        //CHIAMATA SINCRONA
        //RestTemplate restTemplate = new RestTemplate();
        //List<Object> result =List.of(Objects.requireNonNull(restTemplate.postForObject(pizzaServiceUrl, restaurantIdsDTOS , Object[].class)));
        //return result;

        //CHIAMATA ASINCRONA CON MESSAGE BROKER
        //restaurantService.addPizzasToRestaurant(restaurantIdsDTOS);

        //CHIAMATA SINCRONA CON OPEN FEIGN
        pizzaServiceProxyController.addPizzasToRestaurant(restaurantIdsDTOS);
        return null;
    }

    @Override
    @GetMapping("/pizzas/{id}")
    public List<Object> getPizzasByRestaurant(@PathVariable("id") Long restaurantId) {
        //CHIAMATA SINCRONA
        //RestTemplate restTemplate = new RestTemplate();
        //List<Object> result = List.of(Objects.requireNonNull(restTemplate.getForObject(pizzaServiceUrl + "/" + restaurantId, Object[].class)));

        //CHIAMA SINCRONA OPEN FEIGN
        List<Object> result = pizzaServiceProxyController.findPizzaByRestaurant(restaurantId);
        return result;
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
