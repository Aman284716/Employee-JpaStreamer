package com.ust.Employee_JpaStreamer.controller;

import com.ust.Employee_JpaStreamer.model.Employee;
import com.ust.Employee_JpaStreamer.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @GetMapping
    public String test(){
        return "Am UP!";
    }

    @PostMapping("/save")
    public List<Employee> saveEmployee(@RequestBody List<Employee> employee){
        return employeeService.saveEmployee(employee);
    }

    @GetMapping("/groupByCity")
    public Map<String, List<Employee>> groupbyEmployeeByCity(){
        return employeeService.groupbyEmployeeByCity();
    }
    @GetMapping("/findall")
    public List<Employee> groupbyEmployeeByPaymentTier(){
        return employeeService.findAllEmp();
    }
}
