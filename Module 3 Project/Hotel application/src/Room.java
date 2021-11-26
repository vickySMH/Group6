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
}
