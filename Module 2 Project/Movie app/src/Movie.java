import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

enum Genre {
    ACTION, COMEDY, DRAMA, FANTASY, HORROR, MYSTERY, ROMANCE, THRILLER
}

public class Movie implements Serializable {
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
    public void setTitle(String newTitle) {
        title = newTitle;
    }
    public void setGenre(Genre newGenre) {
        genre = newGenre;
    }
    public Genre getGenre() {
        return genre;
    }

    public void setActor(Actor actor) {
       cast.add(actor);
    }
}
