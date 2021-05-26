package com.javacamp.hrms.api.controllers;

import com.javacamp.hrms.business.abstracts.DepartmentService;
import com.javacamp.hrms.core.utilities.results.DataResult;
import com.javacamp.hrms.core.utilities.results.Result;
import com.javacamp.hrms.entities.concretes.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/departments")
public class DepartmentController {

    private final DepartmentService departmentService;

    @Autowired
    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping("/getall")
    public DataResult<List<Department>> getAll() {
        return departmentService.getAll();
    }

    @PostMapping("/add")
    public Result add(@RequestBody Department department) {
        return departmentService.add(department);
    }
}
