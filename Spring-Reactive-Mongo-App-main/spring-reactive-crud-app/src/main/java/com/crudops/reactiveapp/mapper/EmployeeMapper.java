package com.crudops.reactiveapp.mapper;

import com.crudops.reactiveapp.dto.EmployeeDTO;
import com.crudops.reactiveapp.model.EmployeeModel;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;


@Mapper
public interface EmployeeMapper {

    EmployeeMapper INSTANCE = Mappers.getMapper(EmployeeMapper.class);

    EmployeeModel toEmployeeModel(EmployeeDTO employeeDTO);

    EmployeeDTO toEmployeeDTO(EmployeeModel employeeModel);

}
