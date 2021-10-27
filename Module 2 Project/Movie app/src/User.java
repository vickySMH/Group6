import java.io.Serializable;
import java.util.ArrayList;

public class User implements Serializable {

    private static String username = null;
    private static String password = null;
    ArrayList<Movie> favMovies= new ArrayList<Movie>();
    private static ArrayList<History> history = new ArrayList<History>();

    public User(String name, String passcode){
        setUsername(name);
        setPassword(passcode);
    }

    public static String getUsername() {
        return username;
    }

    public static void setUsername(String newUsername) {
        username = newUsername;
    }

    public static String getPassword() {
        return password;
    }

    public static void setPassword(String newPassword) {
        password = newPassword;
    }

    /*public void addFavMovie(Movie movie)
    {

    }*/

    public static void addToHistory(History addDate){
        history.add(addDate);
    }
}
