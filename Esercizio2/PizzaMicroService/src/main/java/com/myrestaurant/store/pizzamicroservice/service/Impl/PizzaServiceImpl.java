package com.myrestaurant.store.pizzamicroservice.service.Impl;

import com.myrestaurant.store.pizzamicroservice.dao.PizzaRepository;
import com.myrestaurant.store.pizzamicroservice.dao.RestaurantIdsRepository;
import com.myrestaurant.store.pizzamicroservice.model.Pizza;
import com.myrestaurant.store.pizzamicroservice.model.RestaurantIds;
import com.myrestaurant.store.pizzamicroservice.service.PizzaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class PizzaServiceImpl implements PizzaService {

    // NB: o utilizzo l'autowired, o iniettarla all'interno del costruttore
    // mettendo final e il requiredArgsConstr.
    // @reqArgConst crea un constructor con tutti gli attributi final
    private final PizzaRepository repository;
    private final RestaurantIdsRepository restaurantIDrepsitory;

    @Override
    public Pizza save(Pizza entity) {
        return repository.save(entity);
    }

    @Override
    public List<Pizza> save(List<Pizza> entities) {
        return (List<Pizza>) repository.saveAll(entities);
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    @Override
    public Optional<Pizza> findById(Long id) {
        return (Optional<Pizza>)repository.findById(id);
    }

    @Override
    public List<Pizza> findAll() {
        return (List<Pizza>) repository.findAll();
    }

    @Override
    public Pizza update(Pizza entity, Long id) {
        Optional<Pizza> pizzaOpt = findById(id);
        if(pizzaOpt.isPresent()){
            return save(entity);
        }
        return null;
    }

    @Override
    public List<Pizza> findByRestaurantId(Long restaurantId) {
        List<RestaurantIds> ids = restaurantIDrepsitory.findByRestaurantId(restaurantId);
        //crea la lista di pizze che dovranno essere ritornate
        List<Pizza> pizzas = new ArrayList<>(ids.size());
        //ciclo per popolare la lista di pizze
        for(RestaurantIds element : ids){
            pizzas.add(repository.findById(element.getPizzaId()).get());
        }
        return pizzas;
    }
/*
    @Override
    public List<Pizza> findByRestaurantId(Long restaurantId) {
        List<Pizza> pizzas = repository.findByRestaurantsIn(
                List.of(
                        Restaurant.builder()
                                .id(restaurantId)
                                .build()

                )
        );
        return pizzas;
    }*/
}
