import java.io.Serializable;
import java.time.LocalDate;

public class History implements Serializable
{
    private LocalDate watchedDate;
    private Movie movie;

    public History(Movie movie, LocalDate watchedDate)
    {
        setMovie(movie);
        setWatchedDate(watchedDate);
    }

    public void setWatchedDate(LocalDate watchedDate)
    {
        this.watchedDate = watchedDate;
    }
    public LocalDate getWatchedDate()
    {
        return watchedDate;
    }

    public void setMovie(Movie movie)
    {
        this.movie = movie;
    }
    public Movie getMovie()
    {
        return movie;
    }

    public String toString()
    {
        return "Movie: " + movie + " watched on: " + watchedDate;
    }
}
