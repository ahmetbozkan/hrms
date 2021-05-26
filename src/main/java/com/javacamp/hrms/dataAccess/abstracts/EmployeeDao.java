package com.javacamp.hrms.dataAccess.abstracts;

import com.javacamp.hrms.entities.concretes.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeDao extends JpaRepository<Employee, Integer> {
}
