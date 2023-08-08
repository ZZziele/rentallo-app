package com.sda.rentalloapp;

import org.junit.jupiter.api.Test;
import org.springframework.test.context.TestPropertySource;

import java.util.stream.Stream;

public class JavaNewFeaturesTests {

    public void multilineString() {
        String meWithAddressOdWay =
                "Mariusz P.            " +
                        "Warsaw                ";

        String mewWithAddressNewWay =
                """
                 Mariusz P.
                 Warsaw    
                 """;


    }

    @Test
    public void streamTest() {
        Stream.of("Ala", " ", "ma", " ", "kota")
                .map(s -> {
                    System.out.println("Mapping string: [%s]".formatted(s));
                    return s.toUpperCase();
                })
                .filter(s -> {
                    System.out.println("Filtered string: [%s]".formatted(s));
                    return s.length() > 2;
                })
                .toList();
    }
}

