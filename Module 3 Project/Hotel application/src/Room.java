import java.time.LocalDate;

public class Room
{

    private int numOfBeds;
    private boolean hasInternetAccess;
    private int pricePerNight;
    private boolean occupied;
    private LocalDate startDate;
    private LocalDate endDate;
    private boolean isClean;

    public boolean isClean() {
        return isClean;
    }
}
