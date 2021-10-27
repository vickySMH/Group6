import java.io.Serializable;
import java.util.ArrayList;

public class User implements Serializable {

    private static String username = "";
    private static String password = "";
    ArrayList<Movie> favMovies= new ArrayList<Movie>();
    ArrayList<History> history = new ArrayList<History>();

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
}
