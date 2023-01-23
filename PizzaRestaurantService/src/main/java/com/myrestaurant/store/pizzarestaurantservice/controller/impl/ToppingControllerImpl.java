package com.myrestaurant.store.pizzarestaurantservice.controller.impl;

import com.myrestaurant.store.pizzarestaurantservice.controller.ToppingController;
import com.myrestaurant.store.pizzarestaurantservice.dto.ToppingDTO;
import com.myrestaurant.store.pizzarestaurantservice.mapper.ToppingMapper;
import com.myrestaurant.store.pizzarestaurantservice.model.Topping;
import com.myrestaurant.store.pizzarestaurantservice.service.ToppingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/toppings")
@RequiredArgsConstructor
public class ToppingControllerImpl implements ToppingController {

    private final ToppingService toppingService;
    private final ToppingMapper toppingMapper;
    @Override
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ToppingDTO save(@RequestBody ToppingDTO toppingDTO) {
        Topping topping = toppingMapper.asEntity(toppingDTO);
        return toppingMapper.asDTO(toppingService.save(topping));
    }

    @Override
    @GetMapping("/{id}")
    public ToppingDTO findById(@PathVariable  Long id) {
        Topping topping =  toppingService.findById(id).orElse(null);
        return toppingMapper.asDTO(topping); // if null it returns null
    }

    @Override
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        toppingService.deleteById(id);
        return;
    }

    @Override
    @GetMapping
    public List<ToppingDTO> list() {
        return toppingMapper.asDTOList(toppingService.findAll());
    }

    @Override
    @PutMapping("/{id}")
    public ToppingDTO update(@PathVariable Long id, @RequestBody ToppingDTO toppingDTO) {
        Topping topping = toppingMapper.asEntity(toppingDTO);
        return toppingMapper.asDTO(toppingService.update(topping, id));
    }
}
