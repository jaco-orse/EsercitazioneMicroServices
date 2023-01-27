package com.myrestaurant.store.restaurantmicroservice.mapper;

import com.myrestaurant.store.restaurantmicroservice.dto.DriverDTO;
import com.myrestaurant.store.restaurantmicroservice.model.Driver;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-01-27T16:37:52+0100",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 17.0.5 (Oracle Corporation)"
)
@Component
public class DriverMapperImpl implements DriverMapper {

    @Override
    public Driver asEntity(DriverDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Driver.DriverBuilder driver = Driver.builder();

        driver.id( dto.getId() );
        driver.name( dto.getName() );

        return driver.build();
    }

    @Override
    public DriverDTO asDTO(Driver entity) {
        if ( entity == null ) {
            return null;
        }

        DriverDTO.DriverDTOBuilder driverDTO = DriverDTO.builder();

        driverDTO.id( entity.getId() );
        driverDTO.name( entity.getName() );

        return driverDTO.build();
    }

    @Override
    public List<Driver> asEntityList(List<DriverDTO> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<Driver> list = new ArrayList<Driver>( dtoList.size() );
        for ( DriverDTO driverDTO : dtoList ) {
            list.add( asEntity( driverDTO ) );
        }

        return list;
    }

    @Override
    public List<DriverDTO> asDTOList(List<Driver> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<DriverDTO> list = new ArrayList<DriverDTO>( entityList.size() );
        for ( Driver driver : entityList ) {
            list.add( asDTO( driver ) );
        }

        return list;
    }
}
