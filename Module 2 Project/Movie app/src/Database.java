import java.io.*;
import java.util.ArrayList;

public abstract class Database{
    private static ArrayList<User> userList = new ArrayList<>();
    private static ArrayList<Movie>movieList = new ArrayList<>();
    private static File movies;
    private static FileOutputStream fos;
    private static ObjectOutputStream output;
    private static File users;
    private static FileOutputStream fos2;
    private static ObjectOutputStream out;

    public static ArrayList<User> getUserList() {
        return userList;
    }

    public static ArrayList<Movie> getMovieList() {
        return movieList;
    }

    private static void openMovies() throws IOException
    {
        movies = new File("Movie app/movies.txt");
        fos = new FileOutputStream(movies, false);
        output = new ObjectOutputStream(fos);
    }
    private static void openUsers() throws IOException
    {
        users = new File("Movie app/users.txt");
        fos2 = new FileOutputStream(users, false);
        out = new ObjectOutputStream(fos2);
    }

    private static void closeMovies() throws IOException
    {
        output.close();
    }

    private static void closeUsers() throws IOException
    {
        out.close();
    }

    public static void addMovie(Movie movie)
    {
        movieList.add(movie);
        addMovieToDatabase();
    }

    public static void addUser(User user)
    {
        userList.add(user);
        addUserToDatabase();
    }

    private static void addMovieToDatabase()
    {
        try
        {
            openMovies();
            output.writeObject(movieList);
            closeMovies();
        }
        catch(IOException e)
        {
            System.out.println("Error in database movie file not found");
        }
    }

    private static void addUserToDatabase()
    {
        try
        {
            openUsers();
            out.writeObject(userList);
            closeUsers();
        }
        catch (IOException e)
        {
            System.out.println("Error in database users file not found");
        }
    }

}