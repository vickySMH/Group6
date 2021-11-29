import java.io.Serializable;
import java.time.LocalDate;

public class Room implements Serializable
{

    private int numOfBeds;
    private boolean hasInternetAccess;
    private int pricePerNight;
    private boolean occupied;
    private LocalDate startDate;
    private LocalDate endDate;
    private boolean isClean;
    private int roomNumber;

    public boolean isClean() {
        return isClean;
    }
    public void cleanRoom(boolean isClean)
    {
        this.isClean = isClean;
    }
    public int getRoomNumber()
    {
        return roomNumber;
    }

    public Room(int beds, boolean hasNet, int price, int roomNum)
    {
        numOfBeds = beds;
        hasInternetAccess = hasNet;
        pricePerNight = price;
        roomNumber = roomNum;
        occupied = false;
        isClean = true;
    }

    public String toString() {
        if (occupied)
        {
            return "Room " + roomNumber + " - is occupied";
        }
        else
        {
            return "Room " + roomNumber + " - is not occupied";
        }
    }

    public void printRoom()
    {
        System.out.println("Room " + roomNumber + " - internet access: " + hasInternetAccess
                + ", price per night: " + pricePerNight + ", number of beds: " + numOfBeds);
    }
    
    public int getPricePerNight() {
        return pricePerNight;
    }

}
