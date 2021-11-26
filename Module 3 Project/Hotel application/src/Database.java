import People.Staff;

import java.io.*;
import java.util.ArrayList;

public class Database implements Serializable
{
    private static File rooms;
    private static File staffFile;
    private static FileInputStream fis;
    private static ObjectInputStream ois;
    private static FileOutputStream fos;
    private static ObjectOutputStream output;
    private static FileOutputStream fos1;
    private static ObjectOutputStream output1;

    private static ArrayList<Staff> staff = new ArrayList<>();
    private static ArrayList<Room> roomList = new ArrayList<>();

    public static ArrayList<Staff> getStaff()
    {
        return staff;
    }

    public static void loadRooms() throws IOException, ClassNotFoundException
    {
        openRooms();
        fis = new  FileInputStream("rooms.ser");
        ois = new ObjectInputStream(fis);
        roomList = (ArrayList<Room>) ois.readObject();
        ois.close();
    }

    public static void loadStaff() throws IOException, ClassNotFoundException
    {
        openStaff();
        fis = new FileInputStream("staff.ser");
        ois = new ObjectInputStream(fis);
        staff = (ArrayList<Staff>) ois.readObject();
        ois.close();
    }

    private static void openRooms() throws IOException
    {
        rooms = new File("rooms.ser");
        fos = new FileOutputStream(rooms, false);
        output = new ObjectOutputStream(fos);
    }

    private static void openStaff() throws IOException
    {
        staffFile = new File("staff.ser");
        fos1 = new FileOutputStream(staffFile, false);
        output1 = new ObjectOutputStream(fos1);
    }


    public static ArrayList<Room> getRooms()
    {
        return roomList;
    }

    private static void closeRooms() throws IOException
    {
        output.close();
    }

    public static void addRoom(Room room)
    {
        roomList.add(room);
        addRoomToDatabase();
    }

    public static void saveDatabase()
    {
        addRoomToDatabase();
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

    private static void closeStaff() throws IOException
    {
        output1.close();
    }

    private static void addStaffToDatabase()
    {

        try
        {
            openStaff();
            output1.writeObject(roomList);
            closeStaff();
        }
        catch(IOException e)
        {
            System.out.println("Error in database, room not found");
        }
    }
    
    public static void addStaff(Staff staff1)
    {
        staff.add(staff1);
        addStaffToDatabase();
    }



}
