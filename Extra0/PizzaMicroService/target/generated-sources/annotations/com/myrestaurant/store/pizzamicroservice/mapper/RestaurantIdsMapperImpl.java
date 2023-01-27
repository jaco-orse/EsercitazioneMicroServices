package com.myrestaurant.store.pizzamicroservice.mapper;

import com.myrestaurant.store.pizzamicroservice.dto.RestaurantIdsDTO;
import com.myrestaurant.store.pizzamicroservice.model.RestaurantIds;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-01-27T16:03:32+0100",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 17.0.5 (Oracle Corporation)"
)
@Component
public class RestaurantIdsMapperImpl implements RestaurantIdsMapper {

    @Override
    public RestaurantIds asEntity(RestaurantIdsDTO dto) {
        if ( dto == null ) {
            return null;
        }

        RestaurantIds restaurantIds = new RestaurantIds();

        restaurantIds.setRestaurantId( dto.getRestaurantId() );
        restaurantIds.setPizzaId( dto.getPizzaId() );

        return restaurantIds;
    }

    @Override
    public RestaurantIdsDTO asDTO(RestaurantIds entity) {
        if ( entity == null ) {
            return null;
        }

        RestaurantIdsDTO.RestaurantIdsDTOBuilder restaurantIdsDTO = RestaurantIdsDTO.builder();

        restaurantIdsDTO.restaurantId( entity.getRestaurantId() );
        restaurantIdsDTO.pizzaId( entity.getPizzaId() );

        return restaurantIdsDTO.build();
    }

    @Override
    public List<RestaurantIds> asEntityList(List<RestaurantIdsDTO> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<RestaurantIds> list = new ArrayList<RestaurantIds>( dtoList.size() );
        for ( RestaurantIdsDTO restaurantIdsDTO : dtoList ) {
            list.add( asEntity( restaurantIdsDTO ) );
        }

        return list;
    }

    @Override
    public List<RestaurantIdsDTO> asDTOList(List<RestaurantIds> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<RestaurantIdsDTO> list = new ArrayList<RestaurantIdsDTO>( entityList.size() );
        for ( RestaurantIds restaurantIds : entityList ) {
            list.add( asDTO( restaurantIds ) );
        }

        return list;
    }
}
