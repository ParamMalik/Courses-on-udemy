package com.apicall.webclientcallingapi.service;

import com.apicall.webclientcallingapi.model.EmployeeModel;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface EmployeeService {
    Flux<EmployeeModel> findAll();

    Mono<EmployeeModel> findById(String Id);

    Mono<EmployeeModel> saveEmpDetails(EmployeeModel employeeModel);

    Mono<EmployeeModel> updateEmpDetails(EmployeeModel employeeModel);

    Mono<Void> deleteEmpDetails(String id);


}
