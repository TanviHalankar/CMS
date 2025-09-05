package com.hrms.attendance_service.service;

import com.hrms.attendance_service.model.Attendance;
import com.hrms.attendance_service.repository.AttendanceRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AttendanceService {

    private final AttendanceRepository repository;

    public AttendanceService(AttendanceRepository repository) {
        this.repository = repository;
    }

    public List<Attendance> getAll() {
        return repository.findAll();
    }

    public Optional<Attendance> getById(Long id) {
        return repository.findById(id);
    }

    public List<Attendance> getByEmployee(Long employeeId) {
        return repository.findByEmployeeId(employeeId);
    }

    public Attendance add(Attendance attendance) {
        return repository.save(attendance);
    }

    public Attendance update(Long id, Attendance attendance) {
        return repository.findById(id)
                .map(existing -> {
                    existing.setEmployeeId(attendance.getEmployeeId());
                    existing.setDate(attendance.getDate());
                    existing.setStatus(attendance.getStatus());
                    existing.setHoursWorked(attendance.getHoursWorked());
                    return repository.save(existing);
                })
                .orElseThrow(() -> new RuntimeException("Attendance not found"));
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}

