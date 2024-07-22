package com.ust.Employee_JpaStreamer.service;

import com.speedment.jpastreamer.application.JPAStreamer;
import com.ust.Employee_JpaStreamer.model.Employee;
import com.ust.Employee_JpaStreamer.repository.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepo employeeRepo;

    private final JPAStreamer jpaStreamer;

    public EmployeeService(JPAStreamer jpaStreamer) {
        this.jpaStreamer = jpaStreamer;
    }

    public List<Employee> saveEmployee(List<Employee> employee) {
        return employeeRepo.saveAll(employee);
    }

    public Map<String, List<Employee>> groupbyEmployeeByCity() {
        return jpaStreamer.stream(Employee.class)
                .collect(Collectors.groupingBy(Employee::getCity));
    }

    public List<Employee> findAllEmp() {
        return employeeRepo.findAll();
    }
}
