package People;

import java.io.Serializable;

public class Employee extends Person implements Serializable
{
    private String title;
    private int salary;
    private User user = new User();

    public Employee(String firstName, String lastName, String title, String phoneNumber, int salary, User user)
    {
        super(firstName, lastName, phoneNumber);
        this.title = title;
        this.salary = salary;
        this.user = user;
    }

    public Employee()
    {
        fullName = "";
        title = "";
        salary = 0;
        phoneNumber = "";
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

    public String getUsername()
    {
        return user.getUsername();
    }

    public String getPassword()
    {
        return user.getPassword();
    }

    public void setPassword(String password)
    {
        user.setPassword(password);
    }

    public void setUsername(String username)
    {
        user.setUsername(username);
    }


}
