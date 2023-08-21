package com.sda.rentalloapp.service;

import com.sda.rentalloapp.Exception.WrongAddressIdException;
import com.sda.rentalloapp.domain.Address;
import com.sda.rentalloapp.repository.AddressRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class LocationService {

    private final AddressRepository addressRepository;

    public LocationService(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    public Address findAddressById(Long addressId){
        return addressRepository.findById(addressId)
                .map(address -> {
                    log.info("Found address: [{}]" , address);
                    return address;
                }).orElseThrow(() ->  new WrongAddressIdException("No address with given id : [%d]".formatted(addressId)));
    }
}
