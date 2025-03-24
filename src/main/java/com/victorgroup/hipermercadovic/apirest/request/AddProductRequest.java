package com.victorgroup.hipermercadovic.apirest.request;

import lombok.Data;

@Data
public class AddProductRequest {
    private Long id;
    private String name;
    private String brand;
}
