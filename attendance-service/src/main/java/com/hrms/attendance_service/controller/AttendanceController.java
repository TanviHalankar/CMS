package com.hrms.attendance_service.controller;

import com.hrms.attendance_service.model.Attendance;
import com.hrms.attendance_service.service.AttendanceService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/attendance")
public class AttendanceController {

    private final AttendanceService service;

    public AttendanceController(AttendanceService service) {
        this.service = service;
    }

    @GetMapping
    public List<Attendance> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Attendance getById(@PathVariable Long id) {
        return service.getById(id).orElseThrow(() -> new RuntimeException("Attendance not found"));
    }

    @GetMapping("/employee/{employeeId}")
    public List<Attendance> getByEmployee(@PathVariable Long employeeId) {
        return service.getByEmployee(employeeId);
    }

    @PostMapping
    public Attendance add(@RequestBody Attendance attendance) {
        return service.add(attendance);
    }

    @PutMapping("/{id}")
    public Attendance update(@PathVariable Long id, @RequestBody Attendance attendance) {
        return service.update(id, attendance);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {
        service.delete(id);
        return "Attendance record deleted successfully";
    }
}

