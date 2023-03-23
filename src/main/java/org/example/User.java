package org.example;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private String name;
    private String email;
    private Address address;
}
@Data
@NoArgsConstructor
@AllArgsConstructor
class Address {
    private String city;
    private String street;
    private int zip;
}
