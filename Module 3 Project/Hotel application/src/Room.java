import People.Guest;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;

public class Room implements Serializable
{

    private int numOfBeds;
    private boolean hasInternetAccess;
    private int pricePerNight;
    private ArrayList<LocalDate>dates = new ArrayList<>();
    private boolean isClean;
    private int roomNumber;
    private ArrayList<Guest> personBooked = new ArrayList<>();

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

    public Room(int beds, boolean hasNet, int price, int roomNum)
    {
        numOfBeds = beds;
        hasInternetAccess = hasNet;
        pricePerNight = price;
        roomNumber = roomNum;
        isClean = true;
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

    public ArrayList<LocalDate> getDates()
    {
        return dates;
    }

    public void addGuests(Guest guest)
    {
        personBooked.add(guest);
    }

    public void setDates(LocalDate startDate, LocalDate endDate)
    {
        dates.add(startDate);
        dates.add(endDate);
    }

    public ArrayList<Guest> getPersonBooked()
    {
        return personBooked;
    }
}
