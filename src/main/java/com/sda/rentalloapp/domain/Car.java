package com.sda.rentalloapp.domain;

import com.sda.rentalloapp.domain.enumeration.BodyType;
import com.sda.rentalloapp.domain.enumeration.EngineType;
import com.sda.rentalloapp.domain.enumeration.FuelType;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "CARS")
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    Long id;

    @Column(nullable = false)
    String model;

    @Column(nullable = false)
    String brand;

    @Enumerated(EnumType.STRING)
    FuelType fuelType;

    @Enumerated(EnumType.STRING)
    EngineType engineType;

    @Enumerated(EnumType.STRING)
    BodyType bodyType;

    int numberOfSeats;

    int trunkCapacityOnLitres;

    String combustionPer100Km;

    @Column(unique = true)
    String bodySerialNumber;

    int pricePedDayInPolishGrosz;

    boolean available;

    int rangeInKm;
    @NotNull
    @Column(nullable = false)
    Pictures pictures;

}
