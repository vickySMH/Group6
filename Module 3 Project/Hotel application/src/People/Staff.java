package People;

public class Staff extends Person
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
