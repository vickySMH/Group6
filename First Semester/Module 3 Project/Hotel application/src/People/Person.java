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
        setPhoneNumber(phoneNumber);
    }

    public String getFullName()
    {
        return fullName;
    }
    
     public void setFullName(String fullName ) {
        this.fullName = fullName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
    
    public void setPhoneNumber(String phoneNumber)
    {
        this.phoneNumber = phoneNumber;
    }
}
