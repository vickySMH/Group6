package com.example.daycare;

public class ModelTableEmployee {

    String name, surname, phoneNumber;
    int id, groupNumber;

    public ModelTableEmployee(int id, int groupNumber, String name, String surname, String phoneNumber) {
        this.id = id;
        this.groupNumber = groupNumber;
        this.name = name;
        this.surname = surname;
        this.phoneNumber = phoneNumber;
    }

    public int getId() {
        return id;
    }

    public int getGroupNumber() {
        return groupNumber;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
}
