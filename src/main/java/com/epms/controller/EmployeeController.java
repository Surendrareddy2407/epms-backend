package com.epms.controller;

import com.epms.entity.Employee;
import com.epms.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService service;

    @PostMapping
    public Employee addEmployee(@RequestBody Employee emp) {
        return service.save(emp);
    }

    @GetMapping
    public List<Employee> getEmployees() {
        return service.getAll();
    }
}