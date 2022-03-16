package com.example.daycare;

import java.sql.Time;
import java.util.Date;

public class ModelTableSchedule {

    Date workday;
    Time startHour, endHour;
    Integer empId;

    public ModelTableSchedule(Date workDay, Time startHour, Time endHour, int employeeID) {
        this.empId = employeeID;
        this.endHour = endHour;
        this.startHour = startHour;
        this.workday = workDay;
    }

    public Date getWorkday() {
        return workday;
    }

    public Integer getEmpId() {
        return empId;
    }

    public Time getStartHour() {
        return startHour;
    }

    public Time getEndHour() {
        return endHour;
    }
}
