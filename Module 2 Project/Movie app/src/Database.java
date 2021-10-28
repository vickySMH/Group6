import java.io.*;
import java.util.ArrayList;

public class Database {

    private static ArrayList<User> userList = new ArrayList<>();
    private static ArrayList<Movie> movieList = new ArrayList<>();

    private static File movies;
    private static FileInputStream fis;
    private static ObjectInputStream ois;
    private static FileOutputStream fos;
    private static ObjectOutputStream output;
    private static FileOutputStream fos2;
    private static ObjectOutputStream out;
    private static File users ;

    public static void loadMovies() throws IOException, ClassNotFoundException
    {
        fis = new FileInputStream("movies.ser");
        ois = new ObjectInputStream(fis);
        movieList = (ArrayList<Movie>) ois.readObject();
        ois.close();
    }

    public static void loadUsers() throws IOException, ClassNotFoundException
    {
        fis = new FileInputStream("users.ser");
        ois = new ObjectInputStream(fis);
        userList = (ArrayList<User>) ois.readObject();
        ois.close();
    }

    public static void openMovies() throws IOException {
        movies = new File("movies.ser");
        fos = new FileOutputStream(movies, false);
        output = new ObjectOutputStream(fos);
    }

    public static ArrayList<User> getUserList() {
        return userList;
    }

    public static ArrayList<Movie> getMovieList() {
        return movieList;
    }


    public static void openUsers() throws IOException{
        users = new File("users.ser");
        fos2 = new FileOutputStream(users, false);
        out = new ObjectOutputStream(fos2);
    }

    public static void closeMovies() throws IOException{
        output.close();
    }

    public static void closeUsers() throws IOException{
        out.close();
    }

    public static void addMovie(Movie movie){
        movieList.add(movie);
        addMovieToDatabase();
    }

    public static void addUser(User user){
        userList.add(user);
        addUserToDatabase();
    }

    public static void saveDatabase()
    {
        addUserToDatabase();
        addMovieToDatabase();
    }

    public static void addMovieToDatabase(){

        try{
            openMovies();
            output.writeObject(movieList);
            closeMovies();
        }
        catch(IOException e){
            System.out.println("Error in database movie file not found");
        }
    }

    public static void addUserToDatabase(){
        try{
            openUsers();
            out.writeObject(userList);
            closeUsers();
        }
        catch (IOException e) {
            System.out.println("Error in database user ");
        }
    }
}
