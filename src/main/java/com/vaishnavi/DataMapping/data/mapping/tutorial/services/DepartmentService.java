package com.vaishnavi.DataMapping.data.mapping.tutorial.services;


import com.vaishnavi.DataMapping.data.mapping.tutorial.entities.DepartmentEntity;
import com.vaishnavi.DataMapping.data.mapping.tutorial.entities.EmployeeEntity;
import com.vaishnavi.DataMapping.data.mapping.tutorial.repositories.DepartmentRepository;
import com.vaishnavi.DataMapping.data.mapping.tutorial.repositories.EmployeeRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class DepartmentService {
    private final DepartmentRepository departmentRepository;

    private final EmployeeRepository employeeRepository;

    public DepartmentService(DepartmentRepository departmentRepository, EmployeeRepository employeeRepository) {
        this.departmentRepository = departmentRepository;
        this.employeeRepository = employeeRepository;
    }

    public DepartmentEntity createNewDepartment(DepartmentEntity departmentEntity){
        return departmentRepository.save(departmentEntity);
    }

    public DepartmentEntity getDepartmentById(Long id){
        return departmentRepository.findById(id).orElse(null);
    }

    public DepartmentEntity assignedManagerToDepartment(Long departmentId, Long employeeId) {
        Optional<DepartmentEntity> departmentEntity = departmentRepository.findById(departmentId);
        Optional<EmployeeEntity> employeeEntity= employeeRepository.findById(employeeId);

        return departmentEntity.flatMap(department ->
                employeeEntity.map(employee ->{
                    department.setManager(employee);
                   return departmentRepository.save(department);
                })).orElse(null);
    }

    public DepartmentEntity getAssignedDepartmentOfManager(Long employeeId) {
//        Optional<EmployeeEntity> employeeEntity = employeeRepository.findById(employeeId);
//        return employeeEntity.map(EmployeeEntity::getManagedDepartment).orElse(null);

        EmployeeEntity employeeEntity  = EmployeeEntity.builder().id(employeeId).build();
        return departmentRepository.findByManager(employeeEntity);

    }

    public DepartmentEntity assignWorkerToDepartment(Long departmentId, Long employeeId) {
        Optional<DepartmentEntity> departmentEntity = departmentRepository.findById(departmentId);
        Optional<EmployeeEntity> employeeEntity= employeeRepository.findById(employeeId);

        return departmentEntity.flatMap(department ->
                employeeEntity.map(employee ->{
                   employee.setWorkerDepartment(department);
                   employeeRepository.save(employee);

                   department.getWorkers().add(employee);
                   return department;
                })).orElse(null);
    }

    @Transactional
    public DepartmentEntity assignFreelancerToDepartment(Long departmentId, Long employeeId) {
        Optional<DepartmentEntity> departmentEntity = departmentRepository.findById(departmentId);
        Optional<EmployeeEntity> employeeEntity= employeeRepository.findById(employeeId);

        return departmentEntity.flatMap(department ->
                employeeEntity.map(employee ->{
                employee.getFreelanceDepartments().add(department);
                employeeRepository.save(employee);
                department.getFreelancers().add(employee);
                   return department;
                })).orElse(null);
    }
}
