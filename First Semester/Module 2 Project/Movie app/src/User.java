import java.io.Serializable;
import java.util.ArrayList;

public class User implements Serializable
{

    private String username;
    private String password;
    private ArrayList<Movie> favMovies= new ArrayList<>();
    private ArrayList<History> history = new ArrayList<>();

    public User(String name, String passcode)
    {
        setUsername(name);
        setPassword(passcode);
    }

    public ArrayList<Movie> getFavMovies()
    {
        return favMovies;
    }

    public User()
    {
        username = "";
        password = "";
    }

    public void removeMovie(Movie movie)
    {
        favMovies.remove(movie);
    }

    public String getUsername()
    {
        return username;
    }

    public void setUsername(String newUsername)
    {
        username = newUsername;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String newPassword)
    {
        password = newPassword;
    }

    public void addFavMovie(Movie movie)
    {
        favMovies.add(movie);
    }

    public void addToHistory(History addDate)
    {
        history.add(addDate);
    }

    public void displayHistory() 
    {
        if(history.size() == 0)
        {
            System.out.println("You have not watched any movies yet!");
        }
        else
        {
            System.out.println("Displaying history...");
            for (History story: history)
            {
                System.out.println(story);
            }
        }

    }

<<<<<<< HEAD:First Semester/Module 2 Project/Movie app/src/User.java
    public void displayFavourites()
    {
        if (favMovies.size() == 0)
        {
            System.out.println("Your list is empty");
        }
        else
        {
            for (Movie movie: favMovies)
            {
=======
    public void displayFavourites(){
        if (favMovies.size() == 0){
            System.out.println("Your list is empty");
        }
        else{
            for (Movie movie: favMovies){
>>>>>>> da48e9a725cfe649e954bf6a2007c081139ec1b4:Module 2 Project/Movie app/src/User.java
                System.out.println(movie);
            }
        }
    }

}
