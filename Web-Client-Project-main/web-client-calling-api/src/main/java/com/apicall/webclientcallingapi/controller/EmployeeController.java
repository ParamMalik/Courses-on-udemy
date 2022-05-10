package com.apicall.webclientcallingapi.controller;

import com.apicall.webclientcallingapi.model.EmployeeModel;
import com.apicall.webclientcallingapi.service.EmployeeService;
import io.micrometer.core.ipc.http.HttpSender;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
@RequestMapping("/employee")
public class EmployeeController {


    private final EmployeeService employeeService;

    @GetMapping
    public ResponseEntity<Flux<EmployeeModel>> getAllEmpData() {
        return ResponseEntity.ok(employeeService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Mono<EmployeeModel>> getEmpDataByName(@PathVariable String id) {
        return ResponseEntity.ok(employeeService.findById(id));
    }

    @PostMapping
    public ResponseEntity<Mono<EmployeeModel>> saveEmpData(@RequestBody EmployeeModel employeeModel) {
        return ResponseEntity.ok(employeeService.saveEmpDetails(employeeModel));
    }

    @PutMapping
    public ResponseEntity<Mono<EmployeeModel>> updateEmpData(@RequestBody EmployeeModel employeeModel) {
        return ResponseEntity.ok(employeeService.updateEmpDetails(employeeModel));
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.GONE)
    public Mono<Void> deleteEmpData(@PathVariable String id) {
        return employeeService.deleteEmpDetails(id);
    }

}
