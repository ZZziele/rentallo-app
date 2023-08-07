package com.sda.rentalloapp.config;


import com.sda.rentalloapp.domain.Car;
import com.sda.rentalloapp.domain.Pictures;
import com.sda.rentalloapp.domain.enumeration.BodyType;
import com.sda.rentalloapp.domain.enumeration.EngineType;
import com.sda.rentalloapp.domain.enumeration.FuelType;
import com.sda.rentalloapp.repository.CarRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Slf4j
@Profile("develop")
public class DataInitializer implements CommandLineRunner {

    private final CarRepository carRepository;

    public DataInitializer(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @Override
    public void run(String... args) {

        log.info("let's create some cars");
        Car mazda = Car.
                builder()
                .model("mazda")
                .brand("VS")
                .fuelType(FuelType.GAS)
                .engineType(EngineType.V8)
                .bodyType(BodyType.HATCHBACK)
                .numberOfSeats(5)
                .trunkCapacityOnLitres(500)
                .combustionPer100Km("5.0/100")
                .bodySerialNumber("1235678")
                .pricePedDayInPolishGrosz(28000)
                .available(true)
                .rangeInKm(500)
                .pictures(new Pictures("https://img.freepik.com/premium-zdjecie/mazda-rx7-na-drodze_917278-30.jpg?w=1060", List.of()))
                .build();

        carRepository.save(mazda);
    }
}
