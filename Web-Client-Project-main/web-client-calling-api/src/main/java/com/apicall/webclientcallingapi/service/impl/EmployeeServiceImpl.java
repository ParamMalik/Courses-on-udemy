package com.apicall.webclientcallingapi.service.impl;

import com.apicall.webclientcallingapi.config.WebClientConfig;
import com.apicall.webclientcallingapi.model.EmployeeModel;
import com.apicall.webclientcallingapi.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {


    private final WebClientConfig webClient;

    @Override
    public Flux<EmployeeModel> findAll() {

        return webClient.getWebClient()
                .get()
                .retrieve()
                .bodyToFlux(EmployeeModel.class);
    }

    @Override
    public Mono<EmployeeModel> findById(String id) {
        return webClient.getWebClient()
                .get()
                .uri("/{id}", id)
                .retrieve().bodyToMono(EmployeeModel.class);
    }

    @Override
    public Mono<EmployeeModel> saveEmpDetails(EmployeeModel employeeModel) {

        return webClient.getWebClient()
                .post()
                .bodyValue(employeeModel)
                .retrieve().bodyToMono(EmployeeModel.class);
    }

    @Override
    public Mono<EmployeeModel> updateEmpDetails(EmployeeModel employeeModel) {

        return webClient.getWebClient()
                .put()
                .bodyValue(employeeModel)
                .retrieve().bodyToMono(EmployeeModel.class);
    }

    @Override
    public Mono<Void> deleteEmpDetails(String id) {
        return webClient.getWebClient()
                .delete()
                .uri("/{id}", id)
                .retrieve()
                .bodyToMono(Void.class);
    }


}
