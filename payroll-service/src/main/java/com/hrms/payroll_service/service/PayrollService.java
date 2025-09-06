package com.hrms.payroll_service.service;

import com.hrms.payroll_service.model.Payroll;
import java.util.List;

public interface PayrollService {
    Payroll generatePayroll(Payroll payroll);
    Payroll markAsPaid(Long id);
    Payroll getPayroll(Long id);
    List<Payroll> getPayrollsByEmployee(Long employeeId);
    void deletePayroll(Long id);
}

