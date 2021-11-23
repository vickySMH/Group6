public class Database
{
    private static File rooms;
    private static FileInputStream fis;
    private static ObjectInputStream ois;
    private static FileOutputStream fos;
    private static ObjectOutputStream output;

    private static ArrayList<Staff> staff = new ArrayList<>();
    private static ArrayList<Room> roomList = new ArrayList<>();

    public static ArrayList<Staff> getStaff()
    {
        return staff;
    }

    public static void loadRooms() throws IOException, ClassNotFoundException
    {
        fis = new FileInputStream("rooms.ser");
        ois = new ObjectInputStream(fis);
        roomList = (ArrayList<Room>) ois.readObject();
        ois.close();
    }
    private static void openRooms() throws IOException
    {
        rooms = new File("rooms.ser");
        fos = new FileOutputStream(rooms, false);
        output = new ObjectOutputStream(fos);
    }

    public static ArrayList<Room> getRoomList() {
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

    private static void addRoomToDatabase(){

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
    {
    }

}
