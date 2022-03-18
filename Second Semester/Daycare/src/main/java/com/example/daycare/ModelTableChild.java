package com.example.daycare;

public class ModelTableChild {

    private String  name, surname, dateOfBirth, parentPhone, parentName, parentSurname, address, groupNumber, cpr, onWaitList;
    private int id;

    public ModelTableChild(int id, String cpr, String name, String surname, String dateOfBirth, String parentPhone,
                           String parentName, String parentSurname, String address, String groupNumber,
                           String onWaitList) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.dateOfBirth = dateOfBirth;
        this.parentPhone = parentPhone;
        this.parentName = parentName;
        this.parentSurname = parentSurname;
        this.address = address;
        this.groupNumber = groupNumber;
        this.cpr = cpr;
        this.onWaitList = onWaitList;
    }

    public int getId() {
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

    public String getCpr() {
        return cpr;
    }

    public String getOnWaitList() {
        return onWaitList;
    }
}
