package com.example.daycare;

public class ModelTableEmployee {

    String groupNumber, name, surname, phoneNumber;
    int id;

    public ModelTableEmployee(int id, String name, String surname, String phoneNumber, String groupNumber) {
        this.id = id;
        this.groupNumber = groupNumber;
        this.name = name;
        this.surname = surname;
        this.phoneNumber = phoneNumber;
    }

    public int getId() {
        return id;
    }

    public String getGroupNumber() {
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
