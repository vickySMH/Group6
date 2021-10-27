import java.util.ArrayList;
import java.util.Scanner;

enum Genre {
    ACTION, COMEDY, DRAMA, FANTASY, HORROR, MYSTERY, ROMANCE, THRILLER
}

public class Movie {
    private ArrayList<Actor> cast = new ArrayList<Actor>();
    private String title;
    private Genre genre;

    public Movie(String title)
    {
        setTitle(title);
    }

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public void setGenre(Genre genre) {
        this.genre = genre;
    }
    public Genre getGenre() {
        return genre;
    }

    public void setActor(Actor actor) {
       cast.add(actor);
    }
}
