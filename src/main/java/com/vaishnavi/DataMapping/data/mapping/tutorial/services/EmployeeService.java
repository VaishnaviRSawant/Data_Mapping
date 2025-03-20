package com.vaishnavi.DataMapping.data.mapping.tutorial.services;

import com.vaishnavi.DataMapping.data.mapping.tutorial.entities.DepartmentEntity;
import com.vaishnavi.DataMapping.data.mapping.tutorial.entities.EmployeeEntity;
import com.vaishnavi.DataMapping.data.mapping.tutorial.repositories.EmployeeRepository;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public EmployeeEntity createNewEmployee(EmployeeEntity employeeEntity) {
        return employeeRepository.save(employeeEntity);
    }

        public EmployeeEntity getEmployeeById(Long id){
            return employeeRepository.findById(id).orElse(null);
        }


}
