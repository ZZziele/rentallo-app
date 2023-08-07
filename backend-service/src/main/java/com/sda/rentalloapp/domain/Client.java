package com.sda.rentalloapp.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "CLIENTS")


public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String name;
    String surname;
    String pesel;
    @Email
    String email;
    LocalDate dateOfBirth;
    String phone;
    @ManyToOne
    Address address;
    LocalDateTime accountCreated;

    @PrePersist
    void setAccountCreated(){
        accountCreated = LocalDateTime.now();
    }



}
