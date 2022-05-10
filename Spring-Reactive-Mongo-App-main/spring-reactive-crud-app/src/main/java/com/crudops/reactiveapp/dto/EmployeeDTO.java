package com.crudops.reactiveapp.dto;

import lombok.Data;

@Data
public class EmployeeDTO {
    private String id;
    private String name;
    private Double salary;
    private String street;
    private String city;

}
