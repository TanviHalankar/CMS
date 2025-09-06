package com.hrms.payroll_service.service;

import com.hrms.payroll_service.model.Payroll;
import com.hrms.payroll_service.repository.PayrollRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class PayrollServiceImpl implements PayrollService {

    private final PayrollRepository repo;

    public PayrollServiceImpl(PayrollRepository repo) {
        this.repo = repo;
    }

    @Override
    public Payroll generatePayroll(Payroll payroll) {
        BigDecimal gross = payroll.getBaseSalary().add(payroll.getAllowances());
        BigDecimal deductions = payroll.getDeductions() != null ? payroll.getDeductions() : BigDecimal.ZERO;
        BigDecimal tax = payroll.getTax() != null ? payroll.getTax() : BigDecimal.ZERO;

        BigDecimal net = gross.subtract(deductions).subtract(tax);
        payroll.setNetPay(net);
        payroll.setStatus("GENERATED");

        return repo.save(payroll);
    }

    @Override
    public Payroll markAsPaid(Long id) {
        Payroll payroll = repo.findById(id).orElseThrow(() -> new RuntimeException("Payroll not found"));
        payroll.setStatus("PAID");
        return repo.save(payroll);
    }

    @Override
    public Payroll getPayroll(Long id) {
        return repo.findById(id).orElseThrow(() -> new RuntimeException("Payroll not found"));
    }

    @Override
    public List<Payroll> getPayrollsByEmployee(Long employeeId) {
        return repo.findByEmployeeId(employeeId);
    }

    @Override
    public void deletePayroll(Long id) {
        repo.deleteById(id);
    }
}
