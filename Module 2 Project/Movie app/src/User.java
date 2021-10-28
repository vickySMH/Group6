import java.io.Serializable;
import java.util.ArrayList;

public class User implements Serializable {

    private String username;
    private String password;
    private ArrayList<Movie> favMovies= new ArrayList<>();
    private ArrayList<History> history = new ArrayList<>();

    public User(String name, String passcode){
        setUsername(name);
        setPassword(passcode);
    }

    public User()
    {
        username = "";
        password = "";
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String newUsername) {
        username = newUsername;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String newPassword) {
        password = newPassword;
    }

    public void addFavMovie(Movie movie)
    {
        favMovies.add(movie);
    }

    public void addToHistory(History addDate){
        history.add(addDate);
    }

}
