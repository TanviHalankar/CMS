package com.hrms.attendance_service.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "attendance")
public class Attendance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long employeeId;     // link to employee-service later
    private LocalDate date;
    private String status;       // PRESENT, ABSENT, LEAVE
    private int hoursWorked;

    public Attendance() {}

    public Attendance(Long employeeId, LocalDate date, String status, int hoursWorked) {
        this.employeeId = employeeId;
        this.date = date;
        this.status = status;
        this.hoursWorked = hoursWorked;
    }

    // Getters & setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Long getEmployeeId() { return employeeId; }
    public void setEmployeeId(Long employeeId) { this.employeeId = employeeId; }

    public LocalDate getDate() { return date; }
    public void setDate(LocalDate date) { this.date = date; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public int getHoursWorked() { return hoursWorked; }
    public void setHoursWorked(int hoursWorked) { this.hoursWorked = hoursWorked; }

    @Override
    public String toString() {
        return "Attendance{" +
                "id=" + id +
                ", employeeId=" + employeeId +
                ", date=" + date +
                ", status='" + status + '\'' +
                ", hoursWorked=" + hoursWorked +
                '}';
    }
}

