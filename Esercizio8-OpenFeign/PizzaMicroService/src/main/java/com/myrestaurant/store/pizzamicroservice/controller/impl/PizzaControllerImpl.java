package com.myrestaurant.store.pizzamicroservice.controller.impl;

import com.myrestaurant.store.pizzamicroservice.controller.PizzaController;
import com.myrestaurant.store.pizzamicroservice.dto.PizzaDTO;
import com.myrestaurant.store.pizzamicroservice.dto.RestaurantIdsDTO;
import com.myrestaurant.store.pizzamicroservice.mapper.PizzaMapper;
import com.myrestaurant.store.pizzamicroservice.mapper.RestaurantIdsMapper;
import com.myrestaurant.store.pizzamicroservice.model.Pizza;
import com.myrestaurant.store.pizzamicroservice.model.RestaurantIds;
import com.myrestaurant.store.pizzamicroservice.service.PizzaService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController //restiturisce gia i risultati in formato json a differenza di controler
@RequestMapping("/pizzas")
@RequiredArgsConstructor // #
@Slf4j
public class PizzaControllerImpl implements PizzaController {

    private final PizzaService pizzaService;// # funziona con RequiredArgConstructor
    private final PizzaMapper pizzaMapper;// # funziona con RequiredArgConstructor
    private final RestaurantIdsMapper restaurantIdsMapper;

    @Override
    @PostMapping("/restaurant")
    public List<PizzaDTO> addPizzasToRestaurant(List<RestaurantIdsDTO> restaurantIdsDTOS) {
        log.info("Pizza Controller --> Into addPizzasToRestaurant method");
        log.info("Sync method to add pizzas");
        List<RestaurantIds> restaurantIds = restaurantIdsMapper.asEntityList(restaurantIdsDTOS);
        return pizzaMapper.asDTOList(pizzaService.addPizzasToRestaurant(restaurantIds));
    }

    @Override
    @GetMapping("/restaurant/{id}")
    public List<PizzaDTO> findPizzaByRestaurant(@PathVariable("id") Long restaurantId) {
        List<Pizza> pizzas = pizzaService.findByRestaurantId(restaurantId);
        return pizzaMapper.asDTOList(pizzas);
    }

    @Override
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public PizzaDTO save(@RequestBody PizzaDTO pizzaDTO) {
        Pizza pizza = pizzaMapper.asEntity(pizzaDTO);
        //Pizza pizzaSaved = pizzaService.save(pizza);
        //PizzaDTO pizzaResponse = pizzaMapper.asDTO(pizzaSaved);
        //return pizzaResponse;
        return pizzaMapper.asDTO(pizzaService.save(pizza));
    }

    @Override
    @GetMapping("/{id}")
    public PizzaDTO findById(@PathVariable Long id) {
        Pizza pizza = pizzaService.findById(id).orElse(null);
        PizzaDTO pizzaDTO = pizzaMapper.asDTO(pizza); // if null it returns null
        return pizzaDTO;
    }

    @Override
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        pizzaService.deleteById(id);
    }

    @Override
    @GetMapping
    public List<PizzaDTO> list() {
        return pizzaMapper.asDTOList(pizzaService.findAll());
    }

    @Override
    @PutMapping("/{id}")
    public PizzaDTO update(@PathVariable Long id, @RequestBody PizzaDTO pizzaDTO) {
        Pizza pizza = pizzaMapper.asEntity(pizzaDTO);
        return pizzaMapper.asDTO(pizzaService.update(pizza,id));
    }
}
