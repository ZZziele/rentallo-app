package com.sda.rentalloapp.service;

import com.sda.rentalloapp.domain.Car;
import com.sda.rentalloapp.domain.CarBooking;
import com.sda.rentalloapp.domain.Client;
import com.sda.rentalloapp.dto.CarBookingRequestDto;
import com.sda.rentalloapp.repository.CarBookingRepository;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;@Service
@Slf4j
public class CarBookingService {

    private final   CarService carService;


    private final ClientService clientService;

    private final CarBookingRepository carBookingRepository;
    public CarBookingService(CarService carService, ClientService clientService, CarBookingRepository carBookingRepository) {
        this.carService = carService;
        this.clientService = clientService;
        this.carBookingRepository = carBookingRepository;
}

    @Transactional
    public CarBooking bookCar(CarBookingRequestDto bookingDto) {
        log.info("Booking car with request: [{}]", bookingDto);
        Car car = carService.findCarById(bookingDto.bookedCarId());
        Client client = clientService.findClientById(bookingDto.clientId());
        return null;
    }
}