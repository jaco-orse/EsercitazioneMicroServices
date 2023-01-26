package com.myrestaurant.store.restaurantmicroservice.service.impl;


import com.myrestaurant.store.restaurantmicroservice.dao.RestaurantRepository;
import com.myrestaurant.store.restaurantmicroservice.dto.RestaurantIdsDTO;
import com.myrestaurant.store.restaurantmicroservice.model.Restaurant;
import com.myrestaurant.store.restaurantmicroservice.service.RestaurantService;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class RestaurantServiceImpl implements RestaurantService {

    private final RestaurantRepository repository;
    private final RabbitTemplate rabbitTemplate;
    @Value("${app.rabbitmq.add-pizzas-routingkey}")
    private String addPizzasToRestaurantRoutingKey;

    @Override
    public Restaurant save(Restaurant entity) {
        return repository.save(entity);
    }

    @Override
    public List<Restaurant> save(List<Restaurant> entities) {
        return repository.saveAll(entities);
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    @Override
    public Optional<Restaurant> findById(Long id) {
        return (Optional<Restaurant>) repository.findById(id);
    }

    @Override
    public List<Restaurant> findAll() {
        return repository.findAll();
    }

    @Override
    public Restaurant update(Restaurant entity, Long id) {
        Optional<Restaurant> restaurantOpt = findById(id);
        if(restaurantOpt.isPresent()){
            return save(entity);
        }
        return null;
    }

    @Override
    public void addPizzasToRestaurant(List<RestaurantIdsDTO> restaurantIdsDTOS) {
        RestTemplate restTemplate = new RestTemplate();
        rabbitTemplate.convertAndSend("",addPizzasToRestaurantRoutingKey,restaurantIdsDTOS);
    }


}
