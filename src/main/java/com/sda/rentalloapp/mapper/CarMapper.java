package com.sda.rentalloapp.mapper;

import com.sda.rentalloapp.domain.Car;
import com.sda.rentalloapp.dto.CarDto;
import com.sda.rentalloapp.dto.PicturesDto;
import org.springframework.stereotype.Component;

@Component

public class CarMapper implements Mapper<Car, CarDto> {
    @Override
    public CarDto fromEntityToDto(Car entity) {
        return CarDto.builder()
                .id(entity.getId())
                .model(entity.getModel())
                .brand(entity.getBrand())
                .fuelType(entity.getFuelType())
                .engineType(entity.getEngineType())
                .bodyType(entity.getBodyType())
                .numberOfSeats(entity.getNumberOfSeats())
                .trunkCapacityInLitres(entity.getTrunkCapacityOnLitres())
                .combustionPer100Km(entity.getCombustionPer100Km())
                .bodySerialNumber(entity.getBodySerialNumber())
                .pricePerDayInPolishGrosz(entity.getPricePedDayInPolishGrosz())
                .available(entity.isAvailable())
                .rangeInKm(entity.getRangeInKm())
                .pictures( new PicturesDto(entity.getPictures().getMainPictureUrl(),entity.getPictures().getPicturesUrl()))
                .build();

    }

    @Override
    public Car fromDtoToEntity(CarDto dto) {
        return null;
    }
}
