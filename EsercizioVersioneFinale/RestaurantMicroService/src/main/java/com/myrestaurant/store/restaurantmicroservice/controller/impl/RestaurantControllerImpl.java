package com.myrestaurant.store.restaurantmicroservice.controller.impl;


import com.myrestaurant.store.restaurantmicroservice.controller.RestaurantController;
import com.myrestaurant.store.restaurantmicroservice.dto.RestaurantDTO;
import com.myrestaurant.store.restaurantmicroservice.dto.RestaurantIdsDTO;
import com.myrestaurant.store.restaurantmicroservice.mapper.RestaurantMapper;
import com.myrestaurant.store.restaurantmicroservice.model.Restaurant;
import com.myrestaurant.store.restaurantmicroservice.service.RestaurantService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    @CircuitBreaker(name = "addPizzasToRestaurantBreaker", fallbackMethod = "addPizzaToRestaurantFailed")
    public ResponseEntity<?> addPizzaToRestaurant(@RequestBody List<RestaurantIdsDTO> restaurantIdsDTOS){
        //CHIAMATA SINCRONA
        //RestTemplate restTemplate = new RestTemplate();
        //List<Object> result = List.of(Objects.requireNonNull(restTemplate.postForObject(pizzaServiceUrl, restaurantIdsDTOS, Object[].class)));

        //CHIAMATA ASINCRONA CON MESSAGE BROKER
        //restaurantService.addPizzasToRestaurant(restaurantIdsDTOS);

        //CHIAMATA SINCRONA CON OPEN FEIGN
        pizzaServiceProxyController.addPizzasToRestaurant(restaurantIdsDTOS);
        return new ResponseEntity<>("Chiamata a PizzaService effettuata",HttpStatus.OK);
    }

    public ResponseEntity<?> addPizzaToRestaurantFailed(Exception e){
        return new ResponseEntity<>("addPizzasToRestaurant CircuitBreaker fallback --> PizzaService non contattatible per aggiungere le pizze",HttpStatus.SERVICE_UNAVAILABLE);
    }

    @Override
    @GetMapping("/pizzas/{id}")
    @CircuitBreaker(name = "getPizzasByRestaurantBreaker", fallbackMethod = "getPizzasByRestaurantFailed")
    public ResponseEntity<List<Object>> getPizzasByRestaurant(@PathVariable("id") Long restaurantId) {
        //CHIAMATA SINCRONA
        //RestTemplate restTemplate = new RestTemplate();
        //List<Object> result = List.of(Objects.requireNonNull(restTemplate.getForObject(pizzaServiceUrl + "/" + restaurantId, Object[].class)));

        //CHIAMA SINCRONA OPEN FEIGN
        List<Object> result = pizzaServiceProxyController.findPizzaByRestaurant(restaurantId);
        return new ResponseEntity<>(result,HttpStatus.OK);
    }

    public ResponseEntity<?> getPizzasByRestaurantFailed(Exception e){
        return new ResponseEntity<>("getPizzasByRestaurant CircuitBreaker fallback --> PizzaService non contattatible per prendere le pizze",HttpStatus.SERVICE_UNAVAILABLE);
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
