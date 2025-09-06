package com.hrms.payroll_service.controller;

import com.hrms.payroll_service.model.Payroll;
import com.hrms.payroll_service.service.PayrollService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/payrolls")
public class PayrollController {

    private final PayrollService service;

    public PayrollController(PayrollService service) {
        this.service = service;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Payroll createPayroll(@RequestBody Payroll payroll) {
        return service.generatePayroll(payroll);
    }

    @PostMapping("/{id}/pay")
    public Payroll markPaid(@PathVariable Long id) {
        return service.markAsPaid(id);
    }

    @GetMapping("/{id}")
    public Payroll getById(@PathVariable Long id) {
        return service.getPayroll(id);
    }

    @GetMapping("/employee/{employeeId}")
    public List<Payroll> getByEmployee(@PathVariable Long employeeId) {
        return service.getPayrollsByEmployee(employeeId);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        service.deletePayroll(id);
    }
}

