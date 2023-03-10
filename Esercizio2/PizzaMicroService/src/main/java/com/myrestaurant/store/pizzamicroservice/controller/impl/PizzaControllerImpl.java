package com.myrestaurant.store.pizzamicroservice.controller.impl;

import com.myrestaurant.store.pizzamicroservice.controller.PizzaController;
import com.myrestaurant.store.pizzamicroservice.dto.PizzaDTO;
import com.myrestaurant.store.pizzamicroservice.mapper.PizzaMapper;
import com.myrestaurant.store.pizzamicroservice.model.Pizza;
import com.myrestaurant.store.pizzamicroservice.service.PizzaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController //restiturisce gia i risultati in formato json a differenza di controler
@RequestMapping("/pizzas")
@RequiredArgsConstructor // #
public class PizzaControllerImpl implements PizzaController {

    private final PizzaService pizzaService;// # funziona con RequiredArgConstructor
    private final PizzaMapper pizzaMapper;// # funziona con RequiredArgConstructor


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
