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
    public String savedata(
            @RequestParam String name,
            @RequestParam String leaveId,
            @RequestParam String leaveEndDate,
            @RequestParam String reportingDate,
            @RequestParam boolean call_Status,
            @RequestParam String call_Response) {

        EmployeeDetails emp = new EmployeeDetails();
        emp.setName(name);
        emp.setLeaveId(leaveId);
        emp.setLeaveEndDate(leaveEndDate);
        emp.setReportingDate(reportingDate);
        emp.setCall_Status(call_Status);
        emp.setCall_Response(call_Response);

        userDetails.savedataservice(emp);

        return "Saved";
    }
}