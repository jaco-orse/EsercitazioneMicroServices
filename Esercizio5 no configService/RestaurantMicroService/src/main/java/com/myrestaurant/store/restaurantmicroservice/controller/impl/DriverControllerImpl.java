package com.myrestaurant.store.restaurantmicroservice.controller.impl;


import com.myrestaurant.store.restaurantmicroservice.controller.DriverController;
import com.myrestaurant.store.restaurantmicroservice.dto.DriverDTO;
import com.myrestaurant.store.restaurantmicroservice.mapper.DriverMapper;
import com.myrestaurant.store.restaurantmicroservice.model.Driver;
import com.myrestaurant.store.restaurantmicroservice.service.DriverService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/drivers")
@RequiredArgsConstructor
public class DriverControllerImpl implements DriverController {

    private final DriverMapper driverMapper;
    private final DriverService driverService;

    @Override
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public DriverDTO save(DriverDTO dDTO) {
        Driver d = driverMapper.asEntity(dDTO);
        return driverMapper.asDTO(driverService.save(d));
    }

    @Override
    @GetMapping("/{id}")
    public DriverDTO findById(Long id) {
        Driver d = driverService.findById(id).orElse(null);
        return driverMapper.asDTO(d);
    }

    @Override
    @DeleteMapping("/{id}")
    public void deleteById(Long id) {
        driverService.deleteById(id);
    }

    @Override
    @GetMapping
    public List<DriverDTO> list() {
        return driverMapper.asDTOList(driverService.findAll());
    }

    @Override
    @PutMapping("/{id}")
    public DriverDTO update(Long id, DriverDTO dDTO) {
        Driver d = driverMapper.asEntity(dDTO);
        return driverMapper.asDTO(driverService.update(d,id));
    }
}
