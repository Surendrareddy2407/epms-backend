package com.epms.service;

import com.epms.entity.Employee;
import com.epms.entity.Project;
import com.epms.repository.EmployeeRepository;
import com.epms.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository repo;

    @Autowired
    private ProjectRepository projectRepository;

    // SAVE SINGLE
    public Employee save(Employee emp) {
        return repo.save(emp);
    }

    // GET ALL
    public List<Employee> getAll() {
        return repo.findAll();
    }

    // 🔥 BULK SAVE
    public List<Employee> saveAll(List<Employee> employees) {
        return repo.saveAll(employees);
    }

    // ASSIGN PROJECT
    public Employee assignProject(Long empId, Long projectId) {

        Employee emp = repo.findById(empId).orElseThrow();
        Project project = projectRepository.findById(projectId).orElseThrow();

        emp.setProject(project);

        return repo.save(emp);
    }
}