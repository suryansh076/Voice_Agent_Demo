package com.example.Voive_Agent.Service;
import com.example.Voive_Agent.model.EmployeeDetails;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class saveUserDetails {

    public List<EmployeeDetails> employeeDetails = new ArrayList<>();

    public String savedataservice(EmployeeDetails emp) {
        employeeDetails.add(emp);
        return "Saved";
    }
}