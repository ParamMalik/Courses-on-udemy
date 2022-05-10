package com.apicall.webclientcallingapi.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Data
@NoArgsConstructor
public class EmployeeModel {
    private String id;
    private String name;
    private Double salary;
    private String street;
    private String city;
}
