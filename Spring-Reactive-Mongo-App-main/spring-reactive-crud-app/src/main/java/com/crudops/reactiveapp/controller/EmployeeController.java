package com.crudops.reactiveapp.controller;

import com.crudops.reactiveapp.dto.EmployeeDTO;
import com.crudops.reactiveapp.service.impl.EmployeeServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/employee")
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeServiceImpl employeeService;

    @GetMapping(path = "/{id}")
    public ResponseEntity<Mono<EmployeeDTO>> findById(@PathVariable String id) {
        return ResponseEntity.ok(employeeService.findById(id));
    }

    @GetMapping
    public ResponseEntity<Flux<EmployeeDTO>> findAllEmployee() {
        return ResponseEntity.ok(employeeService.findAll());
    }

    @PostMapping
    public ResponseEntity<Mono<EmployeeDTO>> saveEmployee(@RequestBody EmployeeDTO employee) {
        return ResponseEntity.ok(employeeService.save(employee));
    }

    @PutMapping
    public ResponseEntity<Mono<EmployeeDTO>> updateSalary(@RequestBody EmployeeDTO employee) {
        return ResponseEntity.ok(employeeService.updateSalary(employee));
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Mono<Void>> deleteById(@PathVariable String id) {
        return ResponseEntity.ok(employeeService.deleteById(id));
    }

}
