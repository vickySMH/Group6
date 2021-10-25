import java.util.ArrayList;

public class User {

    private static String username = null;
    private static String password = null;
    //ArrayList<Moive> = new ArrayList<Movie>;
    //ArrayList<History> = new ArrayList<History>;

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
