package com.crudops.reactiveapp.service.impl;

import com.crudops.reactiveapp.dto.EmployeeDTO;
import com.crudops.reactiveapp.mapper.EmployeeMapper;
import com.crudops.reactiveapp.repository.EmployeeRepository;
import com.crudops.reactiveapp.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    // Find Emp Details By Name

    @Override
    public Mono<EmployeeDTO> findById(String id) {

        return employeeRepository
                .findById(id)
                .map(EmployeeMapper.INSTANCE::toEmployeeDTO);
    }

    // Add Employee to the database
    @Override
    public Mono<EmployeeDTO> save(EmployeeDTO employee) {

        return employeeRepository
                .save(EmployeeMapper.INSTANCE.toEmployeeModel(employee))
                .map(EmployeeMapper.INSTANCE::toEmployeeDTO);
    }


    // Get All Employee from the database
    @Override
    public Flux<EmployeeDTO> findAll() {
        return employeeRepository.findAll().map(EmployeeMapper.INSTANCE::toEmployeeDTO);
    }

    // Delete Employee Using id from database
    @Override
    public Mono<Void> deleteById(String id) {
        return employeeRepository.deleteById(id);
    }

    // Update Salary using name
    @Override
    public Mono<EmployeeDTO> updateSalary(EmployeeDTO employee) {

        return employeeRepository
                .findByName(employee.getName())
                            .defaultIfEmpty(employee)
                            .map(emp -> {
                                emp.setSalary(employee.getSalary());
                                return emp;
                            })
                .map(EmployeeMapper.INSTANCE::toEmployeeModel)
                .flatMap(employeeRepository::save)
                .map(EmployeeMapper.INSTANCE::toEmployeeDTO);


    }
}
