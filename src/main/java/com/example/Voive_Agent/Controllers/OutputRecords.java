package com.example.Voive_Agent.Controllers;

import com.example.Voive_Agent.Service.saveUserDetails;
import com.example.Voive_Agent.model.EmployeeDetails;
import org.apache.poi.xssf.usermodel.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.*;

@RestController
@RequestMapping("/DownloadExcel/")
public class OutputRecords {

    @Autowired
    public saveUserDetails saveuserDetails;

    @GetMapping
    public ResponseEntity<byte[]> downloadExcel() throws IOException {

        try (XSSFWorkbook workbook = new XSSFWorkbook()) {

            XSSFSheet lerfDetails = workbook.createSheet("LERFDetails");

            // Header Row
            XSSFRow row = lerfDetails.createRow(0);
            row.createCell(0).setCellValue("Name");
            row.createCell(1).setCellValue("LeaveId");
            row.createCell(2).setCellValue("leaveEndDate");
            row.createCell(3).setCellValue("LERF Date");
            row.createCell(4).setCellValue("Call Made");
            row.createCell(5).setCellValue("Call Response");

            int rowIndex = 1;

            for (EmployeeDetails e : saveuserDetails.employeeDetails) {

                XSSFRow row1 = lerfDetails.createRow(rowIndex);

                row1.createCell(0).setCellValue(e.getName());
                row1.createCell(1).setCellValue(e.getLeaveId());
                row1.createCell(2).setCellValue(e.getLeaveEndDate());
                row1.createCell(3).setCellValue(e.getReportingDate());
                row1.createCell(4).setCellValue(e.isCall_Status() ? "YES" : "NO");
                row1.createCell(5).setCellValue(e.getCall_Response());

                rowIndex++;
            }

            ByteArrayOutputStream out = new ByteArrayOutputStream();
            workbook.write(out);

            return ResponseEntity.ok()
                    .header("Content-Disposition", "attachment;filename=report.xlsx")
                    .body(out.toByteArray());
        } catch (Exception e) {
            System.out.println("Error " + e);
            return null;
        }
    }
}