import People.Guest;

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
    private Guest[] guestsInRoom = new Guest[numOfBeds];

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
        public int getNumOfBeds() {
        return numOfBeds;
    }
    public boolean occupied() {
        return occupied;
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

    
    public int getPricePerNight()
    {
        return pricePerNight;
    }

    public void setRoomNumber(int roomNumber)
    {
        this.roomNumber = roomNumber;
    }

    public void setHasInternetAccess(boolean hasInternetAccess)
    {
        this.hasInternetAccess = hasInternetAccess;
    }

    public void setNumOfBeds(int numOfBeds)
    {
        this.numOfBeds = numOfBeds;
    }

    public void setPricePerNight(int pricePerNight)
    {
        this.pricePerNight = pricePerNight;
    }
}
