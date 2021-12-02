package People;

import java.io.Serializable;

public class Guest extends Person implements Serializable
{
    private String address;

    public Guest(String firstName, String lastName, String phoneNumber, String address)
    {
        super(firstName,lastName,phoneNumber);
        this.address = address;
    }

    public String toString()
    {
        return fullName;
    }

}
