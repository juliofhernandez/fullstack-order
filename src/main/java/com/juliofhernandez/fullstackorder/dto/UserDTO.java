package com.juliofhernandez.fullstackorder.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {
    private int id;
    private String name;
    private String password;
    private String address;
    private String city;
}
