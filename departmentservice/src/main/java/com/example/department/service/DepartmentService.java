package com.example.department.service.service;

import com.example.department.service.entity.Department;
import com.example.department.service.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DepartmentService {

    @Autowired
    DepartmentRepository departmentRepository;

    public Department saveDepartMent(Department dep){
       return departmentRepository.save(dep);
    }

    public  Department getDepartMent(Long departMentId){
        return  departmentRepository.findByDepartmentId(departMentId);
    }
}
