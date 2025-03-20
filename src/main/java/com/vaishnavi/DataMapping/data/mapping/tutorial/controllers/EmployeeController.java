package com.vaishnavi.DataMapping.data.mapping.tutorial.controllers;

import com.vaishnavi.DataMapping.data.mapping.tutorial.entities.DepartmentEntity;
import com.vaishnavi.DataMapping.data.mapping.tutorial.entities.EmployeeEntity;
import com.vaishnavi.DataMapping.data.mapping.tutorial.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/employees")
public class EmployeeController {

    @Autowired
    private final EmployeeService employeeService;


    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/{employeeId}")
    public EmployeeEntity getEmployeeById(@PathVariable Long employeeId) {
        return employeeService.getEmployeeById(employeeId);

    }

    @PostMapping
    public EmployeeEntity createNewEmployee(@RequestBody EmployeeEntity employeeEntity) {
        return employeeService.createNewEmployee(employeeEntity);
    }
}