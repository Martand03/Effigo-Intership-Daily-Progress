package com.inEffigo.spring_scheduler.scheduler;

import com.inEffigo.spring_scheduler.entity.Report;
import com.inEffigo.spring_scheduler.repository.ReportRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import java.time.LocalDateTime;

@Component
@Slf4j
public class ReportScheduler {

    @Autowired
    private ReportRepository reportRepository;

    @Scheduled(cron = "0/10 * * * * ?")
    public void generateReport(){
        log.info("Scheduled Report Generation Started...");

        try{
            Report report = new Report(null, "Schedule_Report_" + System.currentTimeMillis(),
                    LocalDateTime.now().toString(), "SUCCESS", null);

            reportRepository.save(report);

            log.info("Report generated successfully... at: {}", LocalDateTime.now());

        }catch (Exception e){

            log.error("Report generation failed.. at: {}", LocalDateTime.now());

            Report report = new Report(null, "Failed_Report_" + System.currentTimeMillis(),
                    LocalDateTime.now().toString(), "FAILED", e.getMessage());

            reportRepository.save(report);
        }
    }

}
