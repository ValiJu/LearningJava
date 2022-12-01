package com.example.LearningJava.api;

import com.example.LearningJava.entity.Employee;
import com.example.LearningJava.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.security.RolesAllowed;
import java.util.List;

@RestController
@RequestMapping("/employees")
public class TestingController {
    @Autowired
    private EmployeeService service;

    @GetMapping("/{employeeId}")
    @RolesAllowed("user1")
    public ResponseEntity<Employee> getEmployee(@PathVariable int employeeId) {
        return ResponseEntity.ok(service.getEmployee(employeeId));
    }

    @GetMapping
    @RolesAllowed("admin1")
    public ResponseEntity<List<Employee>> findALlEmployees() {

        return ResponseEntity.ok(service.getAllEmployees());
    }
}
