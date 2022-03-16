package com.example.daycare;

public class ModelTableChild {

    String id, name, surname, dateOfBirth, parentPhone, parentName, parentSurname, address, groupNumber;

    public ModelTableChild(String id, String name, String surname, String dateOfBirth, String parentPhone, String parentName, String parentSurname, String address, String groupNumber) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.dateOfBirth = dateOfBirth;
        this.parentPhone = parentPhone;
        this.parentName = parentName;
        this.parentSurname = parentSurname;
        this.address = address;
        this.groupNumber = groupNumber;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public String getParentPhone() {
        return parentPhone;
    }

    public String getParentName() {
        return parentName;
    }

    public String getParentSurname() {
        return parentSurname;
    }

    public String getAddress() {
        return address;
    }

    public String getGroupNumber() {
        return groupNumber;
    }
}
