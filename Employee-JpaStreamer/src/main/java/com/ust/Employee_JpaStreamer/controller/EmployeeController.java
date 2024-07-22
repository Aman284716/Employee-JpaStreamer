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

    //Age Range
    @GetMapping("/AgeRange/{minAge}/{maxAge}")
    public List<Employee> AgeRange(@PathVariable int minAge, @PathVariable int maxAge){
        return employeeService.getByAgeRange(minAge, maxAge);
    }
    //Count of Gender
    @GetMapping("CountOfGender")
    public Map<String, Long> CountOfGender(){
        return employeeService.CountOfGender();
    }

    //List of Employees on Particular Year
    @GetMapping("EmployeeByYear/{year}")
    public List<Employee> EmployeeByYear(@PathVariable int year){
        return employeeService.EmployeeByYear(year);
    }

    //particular Year Count M/F
    @GetMapping("CountMF/{year}")
    public Map<String, Long> CountMFByYear(@PathVariable int year){
        return employeeService.CountMFByYear(year);
    }
    //GroupByEducation
    @GetMapping("ByEducation")
    public Map<String, List<Employee>> ByEducation(){
        return employeeService.ByEducation();
    }

    //Filter() ON Year M/F Experience And Education
    @GetMapping("{year}/{MorF}/{Exp}/{Edu}")
    public List<Employee> FilterEmployee(@PathVariable int year, @PathVariable String MorF, @PathVariable int Exp, @PathVariable String Edu){
        return employeeService.FilterEmployees(year, MorF, Exp, Edu);
    }
}
