package People;

abstract class Person
{

    protected String fullName;
    protected String phoneNumber;
    protected int ID

    public Person()
    {
        fullName = "";
        phoneNumber = "";
    }
    public Person(String firstName, String lastName, String phoneNumber, int ID)
    {
        fullName = firstName + " " + lastName;
        this.phoneNumber = phoneNumber;
    }
    
    public int getID() {
        return ID;
    }

}
