package People;

import java.io.Serializable;

abstract class Person implements Serializable
{

    protected String fullName;
    protected String phoneNumber;

    public Person()
    {
        fullName = "";
        phoneNumber = "";
    }
    public Person(String firstName, String lastName, String phoneNumber)
    {
        fullName = firstName + " " + lastName;
        this.phoneNumber = phoneNumber;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
}
