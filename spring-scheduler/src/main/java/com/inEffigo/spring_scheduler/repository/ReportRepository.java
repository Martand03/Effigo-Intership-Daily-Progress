package com.inEffigo.spring_scheduler.repository;

import com.inEffigo.spring_scheduler.entity.Report;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReportRepository extends JpaRepository<Report, Long> {
}
