package com.sda.rentalloapp.service;

import com.sda.rentalloapp.Exception.WrongDateInputException;
import com.sda.rentalloapp.domain.Address;
import com.sda.rentalloapp.domain.Car;
import com.sda.rentalloapp.domain.CarBooking;
import com.sda.rentalloapp.domain.Client;
import com.sda.rentalloapp.dto.CarBookingRequestDto;
import com.sda.rentalloapp.repository.CarBookingRepository;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;

@Service
@Slf4j
public class CarBookingService {

    private final   CarService carService;


    private final ClientService clientService;

    private final CarBookingRepository carBookingRepository;

    private final LocationService locationService;


    public CarBookingService(CarService carService, ClientService clientService, CarBookingRepository carBookingRepository, LocationService locationService) {
        this.carService = carService;
        this.clientService = clientService;
        this.carBookingRepository = carBookingRepository;
        this.locationService = locationService;
    }

    @Transactional
    public CarBooking bookCar(CarBookingRequestDto bookingDto) {
        log.info("Booking car with request: [{}]", bookingDto);
        Car car = carService.findCarById(bookingDto.bookedCarId());
        Client client = clientService.findClientById(bookingDto.clientId());
        Address startLocation = locationService.findAddressById(bookingDto.startLocationId());
        Address endlocation = locationService.findAddressById(bookingDto.endLocationId());
        long finalCarBookingPrice = calculateFinalBookingPrice(bookingDto.startDate(),bookingDto.endDate(), car.getPricePedDayInPolishGrosz());

        CarBooking bookingRecord = CarBooking.builder().
                bookedCar(car)
                .client(client)
                .startDate(bookingDto.startDate())
                .endDate(bookingDto.endDate())
                .totalPriceInPolishGrosz(finalCarBookingPrice)
                .startLocation(startLocation)
                .endLocation(endlocation)
                .build();

        CarBooking saved =  carBookingRepository.save(bookingRecord);
        log.info("Created booking record: [{}] ",saved);
        return saved;

    }

    public long calculateFinalBookingPrice(LocalDate startDate,
                                           LocalDate endDate,
                                           long pricePerDayInPolishGrosz) {
        if (startDate.isAfter(endDate) || startDate.isEqual(endDate)) {
            throw new WrongDateInputException("Wrong dates provided, start date = [%s], end date = [%s]".formatted(startDate, endDate));
        }
        long numberOfDays = Period.between(startDate, endDate).getDays();
        long finalPriceInPolishGrosz = pricePerDayInPolishGrosz * numberOfDays;
        log.info("Price for booking car starting on [{}] ending on [{}] is [{}]",
                startDate, endDate, finalPriceInPolishGrosz);
        return finalPriceInPolishGrosz;
    }
}