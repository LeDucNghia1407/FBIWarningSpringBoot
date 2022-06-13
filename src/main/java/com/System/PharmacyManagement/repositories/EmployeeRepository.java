package com.System.PharmacyManagement.repositories;


import com.System.PharmacyManagement.models.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    List<Employee> findByid(Long id);
}
