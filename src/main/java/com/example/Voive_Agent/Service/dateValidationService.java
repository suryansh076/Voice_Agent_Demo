package com.example.Voive_Agent.Service;

import static java.util.Map.of;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Map;

@Service
public class dateValidationService {

    public String validDate(String dateStr,String lesveEndDate)  {
        try {
            DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            LocalDate InputStringDate = LocalDate.parse(dateStr, dateTimeFormatter);
            LocalDate today = LocalDate.parse(lesveEndDate, dateTimeFormatter);

            Map<LocalDate, String> dateMap = Map.ofEntries(
                    Map.entry(LocalDate.parse("2026-01-01"), "New Year's Day"),
                    Map.entry(LocalDate.parse("2026-01-14"), "Makar Sankranti / Pongal"),
                    Map.entry(LocalDate.parse("2026-01-26"), "Republic Day"),
                    Map.entry(LocalDate.parse("2026-03-08"), "Maha Shivaratri"),
                    Map.entry(LocalDate.parse("2026-03-27"), "Holi"),
                    Map.entry(LocalDate.parse("2026-04-14"), "Ambedkar Jayanti / Baisakhi"),
                    Map.entry(LocalDate.parse("2026-04-19"), "Ram Navami"),
                    Map.entry(LocalDate.parse("2026-04-28"), "Eid al-Fitr"),
                    Map.entry(LocalDate.parse("2026-08-15"), "Independence Day"),
                    Map.entry(LocalDate.parse("2026-09-05"), "Ganesh Chaturthi"),
                    Map.entry(LocalDate.parse("2026-10-19"), "Dussehra"),
                    Map.entry(LocalDate.parse("2026-10-29"), "Diwali")
            );

            if (InputStringDate.isBefore(today)) {
                return "This Date is in Past Provide Valid future date";
            }
            else if (InputStringDate.isEqual(today)) {
                return "This Date is today Provide Valid future date";
            }
            else if (InputStringDate.isAfter(today.plusDays(30))) {
                return "This date falls after 30 days Please provide valid date";
            }
            else if (dateMap.containsKey(InputStringDate)) {
                return "There is " + dateMap.get(InputStringDate) + " Holiday on this date";
            }
            else if (InputStringDate.getDayOfWeek().toString().equalsIgnoreCase("Saturday") ||
                    InputStringDate.getDayOfWeek().toString().equalsIgnoreCase("Sunday")) {
                return "This is a weekend provide another Day";
            }

            return "Valid date";

        } catch (Exception e) {
            System.out.println("Error ----------- " + e);
            return "Something Went Wrong";
        }
    }
}