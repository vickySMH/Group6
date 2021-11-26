package People;

import java.io.Serializable;

public class Staff extends Person implements Serializable
{
    private String title;

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
