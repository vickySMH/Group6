package com.example.daycare;

public class ModelTableTeacherSchedule {

    String workday1, startHour1, endHour1;

    public ModelTableTeacherSchedule(String workday, String startHour, String endHour) {
        this.workday1 = workday;
        this.startHour1 = startHour;
        this.endHour1 = endHour;
    }

    public String getWorkday() {
        return workday1;
    }

    public String getStartHour() {
        return startHour1;
    }

    public String getEndHour() {
        return endHour1;
    }

}
