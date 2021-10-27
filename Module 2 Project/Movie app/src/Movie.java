import java.util.ArrayList;
import java.util.Scanner;

enum Genre {
    ACTION, COMEDY, DRAMA, FANTASY, HORROR, MYSTERY, ROMANCE, THRILLER
}

public class Movie {
    private static ArrayList<Actor> cast = new ArrayList<Actor>();
    private static String title;
    private static Genre genre;

    public Movie(String title)
    {
        setTitle(title);
    }

    public static String getTitle() {
        return title;
    }
    public static void setTitle(String newTitle) {
        title = newTitle;
    }
    public static void setGenre(Genre newGenre) {
        genre = newGenre;
    }
    public static Genre getGenre() {
        return genre;
    }

    public static void setActor(Actor actor) {
       cast.add(actor);
    }
}
