package People;

abstract class Person
{

    protected String fullName;
    protected String phoneNumber;

    public Person(String firstName, String lastName, String phoneNumber)
    {
        fullName = firstName + " " + lastName;
        this.phoneNumber = phoneNumber;
    }

}
