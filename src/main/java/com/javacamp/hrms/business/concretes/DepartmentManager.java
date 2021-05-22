package com.javacamp.hrms.business.concretes;

import com.javacamp.hrms.business.abstracts.DepartmentService;
import com.javacamp.hrms.dataAccess.abstracts.DepartmentDao;
import com.javacamp.hrms.entities.concretes.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentManager implements DepartmentService {

    private final DepartmentDao departmentDao;

    @Autowired
    public DepartmentManager(DepartmentDao departmentDao) {
        this.departmentDao = departmentDao;
    }

    @Override
    public List<Department> getAll() {
        return departmentDao.findAll();
    }
}
