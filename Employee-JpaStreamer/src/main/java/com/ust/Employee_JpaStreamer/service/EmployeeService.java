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

    public List<Employee> getByAgeRange(int minAge, int maxAge) {
        return jpaStreamer.stream(Employee.class)
               .filter(employee -> employee.getAge() >= minAge && employee.getAge() <= maxAge)
               .collect(Collectors.toList());
    }

    public Map<String, Long> CountOfGender() {
        return jpaStreamer.stream(Employee.class)
                .collect(Collectors.groupingBy(
                        Employee::getGender,
                        Collectors.counting()
                ));
    }

    public List<Employee> EmployeeByYear(int year) {
        return jpaStreamer.stream(Employee.class)
                .filter(employee -> employee.getJoiningYear() == year)
                .collect(Collectors.toList());
    }

    public Map<String, Long> CountMFByYear(int year) {
        return jpaStreamer.stream(Employee.class)
               .filter(employee -> employee.getJoiningYear() == year)
               .collect(Collectors.groupingBy(
                        Employee::getGender,
                        Collectors.counting()
                ));
    }


    public Map<String, List<Employee>> ByEducation() {
        return jpaStreamer.stream(Employee.class)
                .collect(Collectors.groupingBy(Employee::getEducation));
    }

    public List<Employee> FilterEmployees(int year, String mF, int exp, String edu) {
        return jpaStreamer.stream(Employee.class)
                .filter(Employee -> Employee.getGender().equalsIgnoreCase(mF) &&
                        Employee.getJoiningYear()== year &&
                        Employee.getExperienceInCurrentDomain()==exp &&
                        Employee.getEducation().equals(edu)).collect(Collectors.toList());
    }
}
