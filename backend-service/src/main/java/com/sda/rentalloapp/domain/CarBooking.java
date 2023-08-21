package com.sda.rentalloapp.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
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

    Long totalPriceInPolishGrosz;

    @ManyToOne
    Address startLocation;
    @ManyToOne
    Address endLocation;

     LocalDateTime creationTimestamp = LocalDateTime.now();

     LocalDateTime updateTimestamp;
     @PrePersist
     void writeCreationTimestamp(){
         creationTimestamp = LocalDateTime.now();
         updateTimestamp = creationTimestamp;
     }
     @PreUpdate
     void writeUpdateTimestamp(){
         updateTimestamp = LocalDateTime.now();
     }


}
