package com.vaishnavi.DataMapping.data.mapping.tutorial.repositories;

import com.vaishnavi.DataMapping.data.mapping.tutorial.entities.DepartmentEntity;
import com.vaishnavi.DataMapping.data.mapping.tutorial.entities.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository<DepartmentEntity, Long> {
    DepartmentEntity findByManager (EmployeeEntity employeeEntity);
}
