package com.tastekine.workshop_mongodb.workshop1;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Address {
    private String country;
    private String postCode;
    private String city;

//    public Address(AddressBuilder builder) {
//        this.country = builder.country;
//        this.postCode = builder.postCode;
//        this.city = builder.city;
//    }
}
