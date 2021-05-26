package com.javacamp.hrms.business.concretes;

import com.javacamp.hrms.business.abstracts.DepartmentService;
import com.javacamp.hrms.core.utilities.results.*;
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
    public DataResult<List<Department>> getAll() {
        return new SuccessDataResult<>(
                departmentDao.findAll(),
                "Departments displayed."
        );
    }

    @Override
    public Result add(Department department) {
        if(isDepartmentExists(department.getDepartmentName())) {
            return new ErrorResult("This department is already exists.");
        }
        departmentDao.save(department);
        return new SuccessResult("Department successfully added.");
    }

    private boolean isDepartmentExists(String departmentName) {
        return departmentDao.findByDepartmentName(departmentName).isPresent();
    }
}
