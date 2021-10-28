import java.io.Serializable;
import java.util.ArrayList;

public class Movie implements Serializable {
    private ArrayList<Actor> cast = new ArrayList<Actor>();
    private String title;

    public Movie(String title, ArrayList<Actor> cast)
    {
        setTitle(title);
        this.cast = cast;
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
}
