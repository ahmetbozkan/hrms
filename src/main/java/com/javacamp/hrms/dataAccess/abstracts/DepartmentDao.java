package com.javacamp.hrms.dataAccess.abstracts;

import com.javacamp.hrms.entities.concretes.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentDao extends JpaRepository<Department, Integer> {
}
