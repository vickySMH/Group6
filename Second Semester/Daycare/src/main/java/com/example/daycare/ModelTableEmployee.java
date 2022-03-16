package com.example.daycare;

public class ModelTableEmployee {

    String id, groupNumber, name, surname, phoneNumber;

    public ModelTableEmployee(String id, String groupNumber, String name, String surname, String phoneNumber) {
        this.id = id;
        this.groupNumber = groupNumber;
        this.name = name;
        this.surname = surname;
        this.phoneNumber = phoneNumber;
    }

    public String getId() {
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
