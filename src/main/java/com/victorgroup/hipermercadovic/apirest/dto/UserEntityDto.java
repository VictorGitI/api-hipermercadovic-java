package com.victorgroup.hipermercadovic.apirest.dto;

import lombok.Data;

@Data
public class UserEntityDto {
    private int id;
    private String firstName;
    private String lastName;
    private String email;
}
