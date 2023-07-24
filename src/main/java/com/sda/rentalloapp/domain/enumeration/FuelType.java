package com.sda.rentalloapp.domain.enumeration;

public enum FuelType {
    GAS("gas fuel") ,
    OIL("oil fuel"),
    GASOLINE("gasoline fuel"),
    ELECTRIC("electricity"),
    HYBRID ("hybrid");



    FuelType(String fuelDesc) {
        this.fueltDesc = fuelDesc;
    }

    String fueltDesc;

    public String getFueltDesc() {
        return fueltDesc;
    }
}
