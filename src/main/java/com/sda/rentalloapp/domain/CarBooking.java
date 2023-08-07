package com.sda.rentalloapp.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "RENTS")
public class CarBooking {
    @Id
            @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @ManyToOne
    Car bookedCar;

    @ManyToOne
    Client client;

    LocalDate startDate;

    LocalDate endDate;

    int totalPriceInPolishGrosz;

    @ManyToOne
    Address startLocation;
    @ManyToOne
    Address endLocation;


}
