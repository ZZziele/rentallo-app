package com.sda.rentalloapp.domain;

import jakarta.validation.constraints.Email;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class Client {
    String name;
    String surname;
    String pesel;
    @Email
    String email;
    LocalDate dateOfBirth;
    String phone;
    Address address;
    LocalDateTime accountCreated;




}
