import People.Staff;

import java.util.ArrayList;

public class Database
{
    private static ArrayList<Staff> staff = new ArrayList<>();
    public static void loadStaff()
    {
    }

    public static ArrayList<Staff> getStaff()
    {
        return staff;
    }
}
