package People;

import java.io.Serializable;

public class Staff extends Person implements Serializable
{
    private String title;
    private int salary;
    
    public Staff(String firstName, String lastName, String title, String phoneNumber, int salary)
    {
        super(firstName, lastName, phoneNumber);
        this.title = title;
        this.salary = salary;
    }

    public Staff() {

    }

    public String getTitle()
    {
        return title;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    public String toString()
    {
        return "Name: " + fullName + " Position: " + title + " Phone number: " + phoneNumber;
    }

}
