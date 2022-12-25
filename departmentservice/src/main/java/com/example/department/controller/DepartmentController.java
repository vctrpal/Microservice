package com.example.department.service.controller;

import com.example.department.service.entity.Department;
import com.example.department.service.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/departments")
public class DepartmentController {
    @Autowired
    private DepartmentService departmentService;

    @PostMapping("/")
    public Department saveDepartMent(@RequestBody Department department){
        return departmentService.saveDepartMent(department);
    }

    @GetMapping("/{id}")
    public Department getDepartMent(@PathVariable("id") Long departmentId){
        return departmentService.getDepartMent(departmentId);

    }
}
