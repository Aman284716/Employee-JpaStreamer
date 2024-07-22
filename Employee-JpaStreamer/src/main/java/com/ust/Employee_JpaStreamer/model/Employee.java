package com.ust.Employee_JpaStreamer.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Employee {
    @Id
    private int id;

    private String education;
    private int joiningYear;
    private String city;
    private int paymentTier;
    private int age;
    private String gender;
    private String everBenched;
    private int experienceInCurrentDomain;
    private int leaveOrNot;

}
