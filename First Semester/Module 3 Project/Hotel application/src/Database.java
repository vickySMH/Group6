import People.Employee;
import People.Guest;

import java.io.*;
import java.util.ArrayList;

public class Database
{
    private static FileInputStream fis;
    private static ObjectInputStream ois;
    private static FileOutputStream fos;
    private static ObjectOutputStream output;
    private static FileOutputStream fos1;
    private static ObjectOutputStream output1;
    private static FileOutputStream fos2;
    private static ObjectOutputStream output2;



    private static ArrayList<Employee> staff = new ArrayList<>();
    private static ArrayList<Room> roomList = new ArrayList<>();

    public static ArrayList<Employee> getStaff()
    {
        return staff;
    }


    public static void loadRooms() throws IOException, ClassNotFoundException
    {
        fis = new  FileInputStream("rooms.ser");
        ois = new ObjectInputStream(fis);
        roomList = (ArrayList<Room>) ois.readObject();
        ois.close();

    }

    public static void loadStaff() throws IOException, ClassNotFoundException
    {
        fis = new FileInputStream("staff.ser");
        ois = new ObjectInputStream(fis);
        staff = (ArrayList<Employee>) ois.readObject();
        ois.close();

    }

    private static void openRooms() throws IOException
    {
        fos = new FileOutputStream("rooms.ser", false);
        output = new ObjectOutputStream(fos);
    }

    private static void openStaff() throws IOException
    {
        fos1 = new FileOutputStream("staff.ser", false);
        output1 = new ObjectOutputStream(fos1);
    }

    public static ArrayList<Room> getRooms()
    {
        return roomList;
    }

    public static void addRoom(Room room)
    {
        roomList.add(room);
        addRoomToDatabase();
    }

    public static void saveDatabase()
    {
        addRoomToDatabase();
        addStaffToDatabase();
    }

    private static void closeStaff() throws IOException
    {
        output1.close();
    }

    private static void closeRooms() throws IOException
    {
        output.close();
    }

    private static void addRoomToDatabase()
    {

        try
        {
            openRooms();
            output.writeObject(roomList);
            closeRooms();
        }
        catch(IOException e)
        {
            System.out.println("Error in database, room not found");
        }
    }

    private static void addStaffToDatabase()
    {

        try
        {
            openStaff();
            output1.writeObject(staff);
            closeStaff();
        }
        catch(IOException e)
        {
            System.out.println("Error in database, room not found");
        }
    }

    public static void addStaff(Employee staff1)
    {
        staff.add(staff1);
        addStaffToDatabase();
    }

    public static void accounts()
    {
        for (Employee employee : staff)
        {
            employee.printUser();
        }
        if (Database.getStaff().isEmpty())
        {
            System.out.println("No accounts yet!");
        }
    }

}
