package com.sda.rentalloapp.mapper;

import com.sda.rentalloapp.domain.Car;
import com.sda.rentalloapp.dto.CarDto;

public interface Mapper<E,D> {
    D fromEntityToDto(E entity);
    E fromDtoToEntity(D dto);
}