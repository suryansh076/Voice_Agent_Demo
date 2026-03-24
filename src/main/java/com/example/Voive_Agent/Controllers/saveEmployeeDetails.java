package com.example.Voive_Agent.Controllers;

import com.example.Voive_Agent.Service.saveUserDetails;
import com.example.Voive_Agent.model.EmployeeDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/saveDetails")
public class saveEmployeeDetails {

    @Autowired
    private saveUserDetails userDetails;

    @PostMapping
    public String savedata(@RequestBody EmployeeDetails emp) {


        userDetails.savedataservice(emp);

        return "Saved";
    }
}