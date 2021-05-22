package com.javacamp.hrms.business.abstracts;

import com.javacamp.hrms.entities.concretes.Department;

import java.util.List;

public interface DepartmentService {

    List<Department> getAll();
}
