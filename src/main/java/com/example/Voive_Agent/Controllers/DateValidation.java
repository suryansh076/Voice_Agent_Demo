package com.example.Voive_Agent.Controllers;
import com.example.Voive_Agent.Service.dateValidationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/vaidateDate")
public class DateValidation {

    @Autowired
    private dateValidationService dateValidationService;

    @GetMapping
    public ResponseEntity<String> validateDate(
            @RequestParam String dateString) {

        // NOTE: year/day/month variables missing in image, so using direct input
        return ResponseEntity.ok()
                .body(dateValidationService.validDate(dateString));
    }
}