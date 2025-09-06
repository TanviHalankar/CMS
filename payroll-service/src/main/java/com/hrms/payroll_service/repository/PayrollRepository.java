package com.hrms.payroll_service.repository;

import com.hrms.payroll_service.model.Payroll;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PayrollRepository extends JpaRepository<Payroll, Long> {
    Optional<Payroll> findByEmployeeIdAndMonthAndYear(Long employeeId, Integer month, Integer year);
    List<Payroll> findByEmployeeId(Long employeeId);
}

