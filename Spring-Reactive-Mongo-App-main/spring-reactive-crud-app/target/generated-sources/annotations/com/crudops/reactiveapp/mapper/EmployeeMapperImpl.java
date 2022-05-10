package com.crudops.reactiveapp.mapper;

import com.crudops.reactiveapp.dto.EmployeeDTO;
import com.crudops.reactiveapp.model.EmployeeModel;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-05-10T07:44:22+0530",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17 (Oracle Corporation)"
)
public class EmployeeMapperImpl implements EmployeeMapper {

    @Override
    public EmployeeModel toEmployeeModel(EmployeeDTO employeeDTO) {
        if ( employeeDTO == null ) {
            return null;
        }

        EmployeeModel employeeModel = new EmployeeModel();

        employeeModel.setId( employeeDTO.getId() );
        employeeModel.setName( employeeDTO.getName() );
        employeeModel.setSalary( employeeDTO.getSalary() );
        employeeModel.setStreet( employeeDTO.getStreet() );
        employeeModel.setCity( employeeDTO.getCity() );

        return employeeModel;
    }

    @Override
    public EmployeeDTO toEmployeeDTO(EmployeeModel employeeModel) {
        if ( employeeModel == null ) {
            return null;
        }

        EmployeeDTO employeeDTO = new EmployeeDTO();

        employeeDTO.setId( employeeModel.getId() );
        employeeDTO.setName( employeeModel.getName() );
        employeeDTO.setSalary( employeeModel.getSalary() );
        employeeDTO.setStreet( employeeModel.getStreet() );
        employeeDTO.setCity( employeeModel.getCity() );

        return employeeDTO;
    }
}
