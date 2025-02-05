package com.inEffigo.spring_scheduler.controller;

import com.inEffigo.spring_scheduler.entity.Report;
import com.inEffigo.spring_scheduler.repository.ReportRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/api/reports")
@Slf4j
public class ReportController {

    @Autowired
    private ReportRepository reportRepository;

    @PostMapping("/generate")
    public ResponseEntity<String> generateManualReport(){

        log.info("Manual Report Generation Triggered");

        try {
            Report report = new Report(null, "Manual_Report_" + System.currentTimeMillis(),
                    LocalDateTime.now().toString(), "SUCCESS", null);
            reportRepository.save(report);
            log.info("Manual report generated successfully...");
            return ResponseEntity.ok("Manual report generation done!!");
        } catch (Exception e) {
            log.error("Error in manual report generation");
            Report report = new Report(null, "Manual_Report_"+ System.currentTimeMillis(),
                    LocalDateTime.now().toString(), "FAILED", e.getMessage());
            reportRepository.save(report);
            return ResponseEntity.internalServerError().body("Manual Report Generation Failed !!");
        }
    }
}
