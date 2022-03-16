package com.example.daycare;

import java.util.Date;

public class ModelTableKid {

    String name, surname, parentName, parentSurname, parentPhone,address, groupNumber, id, birtday;

    public ModelTableKid(String id, String name, String surname, String dateOfBirth, String parentPhone, String parentName, String parentSurname, String address, String groupNumber) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.birtday = dateOfBirth;
        this.parentName = parentName;
        this.parentSurname = parentSurname;
        this.address = address;
        this.groupNumber = groupNumber;
        this.parentPhone = parentPhone;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getBirtday() {
        return birtday;
    }

    public String getId() {
        return id;
    }

    public String getAddress() {
        return address;
    }

    public String getGroupNumber() {
        return groupNumber;
    }

    public String getParentName() {
        return parentName;
    }

    public String getParentSurname() {
        return parentSurname;
    }


}
