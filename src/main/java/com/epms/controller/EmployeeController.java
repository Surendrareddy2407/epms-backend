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

    // CREATE SINGLE EMPLOYEE
    @PostMapping
    public Employee addEmployee(@RequestBody Employee emp) {
        return service.save(emp);
    }

    // GET ALL EMPLOYEES
    @GetMapping
    public List<Employee> getEmployees() {
        return service.getAll();
    }
    @GetMapping("/{id}")
    public Employee getEmployee(@PathVariable Long id) {
    	return service.getById(id);
    }
    @PutMapping("/{id}")
    public Employee updateEmployee(@PathVariable Long id, @RequestBody Employee emp) {
    	return service.updateEmployee(id, emp);
    }
    @DeleteMapping("/{id}")
    public String deleteEmployee(@PathVariable Long id) {
    	service.deleteEmployee(id);
    	return "Employee deleted successfully";
    	
    }

    // ASSIGN PROJECT
    @PutMapping("/{empId}/assign/{projectId}")
    public Employee assignProject(@PathVariable Long empId,
                                  @PathVariable Long projectId) {
        return service.assignProject(empId, projectId);
    }

    // 🔥 BULK CREATE
    @PostMapping("/bulk")
    public List<Employee> createEmployees(@RequestBody List<Employee> employees) {
        return service.saveAll(employees);
    }
}