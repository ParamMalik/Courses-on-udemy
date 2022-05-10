package com.crudops.reactiveapp.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(value = "Employee_Data")
public class EmployeeModel {

    @Id
    private String id;

    private String name;
    private Double salary;
    private String street;
    private String city;

}
