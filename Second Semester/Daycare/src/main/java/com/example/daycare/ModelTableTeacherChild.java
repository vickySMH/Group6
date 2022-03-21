package com.example.daycare;

public class ModelTableTeacherChild {

    private String  name, surname, dateOfBirth, parentPhone, parentName, parentSurname, address, cpr, onWaitList;
    private int id;

    public ModelTableTeacherChild(int id, String cpr, String name, String surname, String dateOfBirth, String parentPhone,
                           String parentName, String parentSurname, String address,
                           String onWaitList) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.dateOfBirth = dateOfBirth;
        this.parentPhone = parentPhone;
        this.parentName = parentName;
        this.parentSurname = parentSurname;
        this.address = address;
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

    public String getCpr() {
        return cpr;
    }

    public String getOnWaitList() {
        return onWaitList;
    }

//    private String  name1, surname1, dateOfBirth1, parentPhone1, parentName1, parentSurname1, address1, cpr1, onWaitList1;
//    private int id1;
//
//    public ModelTableTeacherChild(int id, String cpr, String name, String surname, String dateOfBirth, String parentPhone,
//                                  String parentName, String parentSurname, String address,
//                                  String onWaitList) {
//        this.id1 = id;
//        this.name1 = name;
//        this.surname1 = surname;
//        this.dateOfBirth1 = dateOfBirth;
//        this.parentPhone1 = parentPhone;
//        this.parentName1 = parentName;
//        this.parentSurname1 = parentSurname;
//        this.address1 = address;
//        this.cpr1 = cpr;
//        this.onWaitList1 = onWaitList;
//    }
//
//    public int getId() {
//        return id1;
//    }
//
//    public String getName() {
//        return name1;
//    }
//
//    public String getSurname() {
//        return surname1;
//    }
//
//    public String getDateOfBirth() {
//        return dateOfBirth1;
//    }
//
//    public String getParentPhone() {
//        return parentPhone1;
//    }
//
//    public String getParentName() {
//        return parentName1;
//    }
//
//    public String getParentSurname() {
//        return parentSurname1;
//    }
//
//    public String getAddress() {
//        return address1;
//    }
//
//    public String getCpr() {
//        return cpr1;
//    }
//
//    public String getOnWaitList() {
//        return onWaitList1;
//    }
}
