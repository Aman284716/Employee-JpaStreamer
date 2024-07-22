package com.ust.Employee_JpaStreamer.repository;

import com.ust.Employee_JpaStreamer.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.mongodb.repository.MongoRepository;

public interface EmployeeRepo extends JpaRepository<Employee,Integer> {
}
