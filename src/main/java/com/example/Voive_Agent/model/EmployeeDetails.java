package com.example.Voive_Agent.model;

public class EmployeeDetails {

    public String name;
    public String leaveId;
    public String leaveEndDate;
    public String reportingDate;
    public boolean call_Status;
    public String call_Response;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLeaveEndDate() {
        return leaveEndDate;
    }

    public void setLeaveEndDate(String leaveEndDate) {
        this.leaveEndDate = leaveEndDate;
    }

    public String getLeaveId() {
        return leaveId;
    }

    public void setLeaveId(String leaveId) {
        this.leaveId = leaveId;
    }

    public String getReportingDate() {
        return reportingDate;
    }

    public void setReportingDate(String reportingDate) {
        this.reportingDate = reportingDate;
    }

    public boolean isCall_Status() {
        return call_Status;
    }

    public void setCall_Status(boolean call_Status) {
        this.call_Status = call_Status;
    }

    public String getCall_Response() {
        return call_Response;
    }

    public void setCall_Response(String call_Response) {
        this.call_Response = call_Response;
    }
}