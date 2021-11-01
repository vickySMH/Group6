import java.io.Serializable;
import java.util.ArrayList;

public class Movie implements Serializable {
    private ArrayList<Actor> cast = new ArrayList<Actor>();
    private String title;
    private int releaseYear;

    public Movie(String title, ArrayList<Actor> cast, int year)
    {
        setTitle(title);
        this.cast = cast;
        setReleaseYear(year);

    }

    public int getReleaseYear()
    {
        return releaseYear;
    }

    public void setReleaseYear(int releaseYear)
    {
        this.releaseYear = releaseYear;
    }

    public String getTitle() {
        return title;
    }
    public void setTitle(String newTitle) {
        title = newTitle;
    }
    public void setActor(Actor actor) {
       cast.add(actor);
    }

    public void playMovie(){
        for (Actor actor : cast){
            System.out.println(actor);
        }
    }

    public ArrayList<Actor> getCast() {
        return cast;
    }

    public String toString()
    {
        return title;
    }
}
