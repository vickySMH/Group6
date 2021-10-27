import java.util.ArrayList;
import java.time.LocalDate;


public class History {

    private static ArrayList<LocalDate> watchedDates = new ArrayList<>();
    private static Movie movie;

    public History(Movie m, LocalDate date){
        setMovie(m);
        addWatchedDate(date);
    }

    public static void addWatchedDate(LocalDate watchedDate){
       watchedDates.add(watchedDate);
    }
    public static ArrayList<LocalDate> getWatchedDate(){
        return watchedDates;
    }

    public static void setMovie(Movie newMovie){
        movie = newMovie;
    }
    public Movie getMovie(){
        return movie;
    }
}
