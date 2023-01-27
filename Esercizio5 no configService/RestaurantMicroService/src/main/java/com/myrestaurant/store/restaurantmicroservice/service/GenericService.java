package com.myrestaurant.store.restaurantmicroservice.service;

import java.util.List;
import java.util.Optional;

public interface GenericService<E,H> {

    E save(E entity);
    List<E> save (List<E> entities);
    void deleteById(H id);
    Optional<E> findById(H id);
    List<E> findAll();
    E update(E entity, H id);

}
