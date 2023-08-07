package com.sda.rentalloapp.dto;

import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.Email;

import java.time.LocalDate;
import java.time.LocalDateTime;

public record ClientDto(


        Long id,
        String name,
        String surname,
        String pesel,
        String email,
        LocalDate dateOfBirth,
        String phone,

        AddressDto addressDto,
        LocalDateTime accountCreated
) {
}
