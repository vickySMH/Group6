import java.io.*;
import java.util.ArrayList;

public class Database
{

    private static ArrayList<User> userList = new ArrayList<>();
    private static ArrayList<Movie> movieList = new ArrayList<>();
    private static ArrayList<Actor> actorList = new ArrayList<>();

    private static File actors;
    private static FileOutputStream fos3;
    private static ObjectOutputStream out1;
    private static File movies;
    private static FileInputStream fis;
    private static ObjectInputStream ois;
    private static FileOutputStream fos;
    private static ObjectOutputStream output;
    private static FileOutputStream fos2;
    private static ObjectOutputStream out;
    private static File users ;

    public static void loadActors() throws IOException, ClassNotFoundException
    {
        fis = new FileInputStream("actors.ser");
        ois = new ObjectInputStream(fis);
<<<<<<< HEAD:First Semester/Module 2 Project/Movie app/src/Database.java
        actorList = (ArrayList<Actor>) ois.readObject();
=======
        movieList = (ArrayList<Movie>) ois.readObject();
>>>>>>> da48e9a725cfe649e954bf6a2007c081139ec1b4:Module 2 Project/Movie app/src/Database.java
        ois.close();
    }

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

    private static void openMovies() throws IOException
    {
        movies = new File("movies.ser");
        fos = new FileOutputStream(movies, false);
        output = new ObjectOutputStream(fos);
    }

<<<<<<< HEAD:First Semester/Module 2 Project/Movie app/src/Database.java
    private static void openActors() throws IOException
    {
        actors = new File("actors.ser");
        fos3 = new FileOutputStream(actors, false);
        out1 = new ObjectOutputStream(fos3);
    }

    private static void closeActors() throws IOException
=======
    public static void openActors() throws IOException
    {
        users = new File("actors.ser");
        fos3 = new FileOutputStream(users, false);
        out1 = new ObjectOutputStream(fos3);
    }

    public static void closeActors() throws IOException
>>>>>>> da48e9a725cfe649e954bf6a2007c081139ec1b4:Module 2 Project/Movie app/src/Database.java
    {
        out1.close();
    }

    public static ArrayList<User> getUserList() {
        return userList;
    }

    public static ArrayList<Movie> getMovieList() {
        return movieList;
    }


    private static void openUsers() throws IOException
    {
        users = new File("users.ser");
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

    public static void addActor(Actor actor)
    {
        actorList.add(actor);
        addActorToDatabase();
    }

    private static void addActorToDatabase()
    {
<<<<<<< HEAD:First Semester/Module 2 Project/Movie app/src/Database.java
        try
        {
=======
        try{
>>>>>>> da48e9a725cfe649e954bf6a2007c081139ec1b4:Module 2 Project/Movie app/src/Database.java
            openActors();
            out1.writeObject(actorList);
            closeActors();
        }
<<<<<<< HEAD:First Semester/Module 2 Project/Movie app/src/Database.java
        catch(IOException e)
        {
=======
        catch(IOException e){
>>>>>>> da48e9a725cfe649e954bf6a2007c081139ec1b4:Module 2 Project/Movie app/src/Database.java
            System.out.println("Error in database actor file not found");
        }
    }


    public static void saveDatabase()
    {
        addUserToDatabase();
        addMovieToDatabase();
        addActorToDatabase();
    }

    private static void addMovieToDatabase(){

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

<<<<<<< HEAD:First Semester/Module 2 Project/Movie app/src/Database.java
    private static void addUserToDatabase()
    {
        try
        {
=======
    private static void addUserToDatabase(){
        try{
>>>>>>> da48e9a725cfe649e954bf6a2007c081139ec1b4:Module 2 Project/Movie app/src/Database.java
            openUsers();
            out.writeObject(userList);
            closeUsers();
        }
        catch (IOException e)
        {
            System.out.println("Error in database user ");
        }
    }

    public static ArrayList<Actor> getActorList()
    {
        return actorList;
    }
}
