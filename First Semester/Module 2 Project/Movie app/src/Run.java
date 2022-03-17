import javax.xml.crypto.Data;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Locale;

public class Run
{
    private BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private String cmd;
    private String[] command;
    private User newUser = new User();
    public void run() throws IOException
    {
        try
        {
            Database.loadUsers();
            Database.loadMovies();
            Database.loadActors();
        }
        catch (Exception e)
        {
            System.out.println("Error loading from our database, please try again!");
        }

        startMessage();
        while(command[0].compareToIgnoreCase("quit") != 0)
        {
            Database.saveDatabase();
            if(command[0].equalsIgnoreCase("add") && newUser.getUsername().equalsIgnoreCase("admin"))
            {
                adminAdd();
            }
            else if(command[0].equalsIgnoreCase("remove") && newUser.getUsername().equalsIgnoreCase("admin"))
            {
                adminRemove();
            }
            else if(command[0].equalsIgnoreCase("help"))
            {
                helpMessage();
            }
            else if(command[0].equalsIgnoreCase("add") && !newUser.getUsername().equalsIgnoreCase("admin"))
            {
                addMovie();
            }
            else if(command[0].equalsIgnoreCase("login") && newUser.getUsername().isBlank())
            {
                login();
            }
            else if(command[0].equalsIgnoreCase("register") && newUser.getUsername().isBlank())
            {
                register();
            }
            else if(command[0].equalsIgnoreCase("list"))
            {
                listMovies();
            }
            else if(command[0].equalsIgnoreCase("actors"))
            {
                listActors();
            }
            else if((command[0].equalsIgnoreCase("logout") || cmd.equalsIgnoreCase("logout")) && !newUser.getUsername().isBlank())
            {
                logout();
            }
            else if(command[0].equalsIgnoreCase("play") && !newUser.getUsername().isBlank())
            {
                play();
            }
            else if(command[0].equalsIgnoreCase("remove") && !newUser.getUsername().equalsIgnoreCase("admin")){
                removeMovie();
            }
            else if(command[0].equalsIgnoreCase("history") && !newUser.getUsername().isBlank())
            {
                history();
            }
<<<<<<< HEAD:First Semester/Module 2 Project/Movie app/src/Run.java
            else if (command[0].equalsIgnoreCase("favourites") && !newUser.getUsername().isBlank())
            {
                favourites();
            }
            else if (command[0].equalsIgnoreCase("search")){
                search();
            }
=======
            else if (command[0].equalsIgnoreCase("favourites") && !newUser.getUsername().isBlank()){
                favourites();
            }
>>>>>>> da48e9a725cfe649e954bf6a2007c081139ec1b4:Module 2 Project/Movie app/src/Run.java
            else
            {
                System.out.println("Unknown command or you must be logged in/out to use it. Check 'help' for more information! ");
                System.out.print("Please enter a command: ");
                cmd = reader.readLine();
                command = cmd.split(" ", 2);
            }
        }
        Database.saveDatabase();
        System.out.println("Thank you for using Kaizen's movie app");
    }

    private void register() throws IOException{
        command = cmd.split(" ", 3);
        String username;

        try
        {

            if(command[1] == null || command[1].length() < 4 || command[1].length() > 20){
                do
                {
                    System.out.println("You need to enter a new username");
                    cmd = reader.readLine();
                    command = cmd.split(" ", 2);
                    username = command[0];
                }
                while(command[0] == null || command[0].length() < 4 || command[0].length() > 20);

                newUser.setUsername(command[0]);
            }
            else
            {
                username = command[1];
                newUser.setUsername(command[1]);
            }

            int i = 0;
            for(User user : Database.getUserList())
            {
                if(user.getUsername().equals(newUser.getUsername())){
                    System.out.println("Username already exists!");
                    newUser.setUsername("");
                    break;
                }
                ++i;
            }

            String password;
            if(i == Database.getUserList().size()){
                do
                {
                    do
                    {
                        System.out.println("Please enter your desired password between 5 and 16 characters!");
                        cmd = reader.readLine();
                        command = cmd.split(" ", 2);
                        password = command[0];
                    }
                    while(password.length() <= 5 || password.length() >= 16);
                    System.out.println("Please, confirm your password!");

                    cmd = reader.readLine();
                    command = cmd.split(" ", 2);
                }
                while(!command[0].equals(password));
                newUser.setUsername(username);
                newUser.setPassword(password);
                Database.addUser(newUser);
                System.out.println("Successfully registered and logged in!");
            }
        }
        catch (ArrayIndexOutOfBoundsException e)
        {
            System.out.println("Invalid command. Check 'help' for more information!");
        }
        System.out.print("Please enter a command: ");
        cmd = reader.readLine();
        command = cmd.split(" ", 2);
    }

    private void login() throws IOException
    {
        command = cmd.split(" ", 3);
        int passwordCounter = 0;

        try
        {
            String username;
            if(command[1] == null || command[1].length() < 4 || command[1].length() > 20)
            {
                do
                {
                    System.out.println("Please enter a username!");
                    cmd = reader.readLine();
                    command = cmd.split(" ", 2);
                }
                while(command[0] == null || command[0].length() < 4 || command[0].length() > 20);

                newUser.setUsername(command[0]);
            }
            else
            {
                newUser.setUsername(command[1]);
            }
            int i = 0;
            for (User user : Database.getUserList())
            {
                if(user.getUsername().equals(newUser.getUsername()))
                {
                    System.out.print("Please enter password: ");
                    do
                    {
                        cmd = reader.readLine();
                        newUser.setPassword(cmd);
                        if (user.getPassword().equals(newUser.getPassword()))
                        {
                            passwordCounter = 5;
                            newUser = user;
                            System.out.println("You have successfully logged in!");
                            break;
                        }
                        else
                        {
                            ++passwordCounter;
                            if(passwordCounter == 1)
                            {
                                System.out.println("You have entered your password incorrectly " + passwordCounter +
                                        " time, you are allowed to enter it 3 times incorrectly," +
                                        "after this your login will be canceled");
                            }
                            else
                            {
                                System.out.println("You have entered your password incorrectly" + passwordCounter +
                                        " times, you are allowed to enter it 3 times incorrectly," +
                                        "after this your login will be canceled");
                            }

                        }
                    }
                    while(passwordCounter < 3);
                }
                if(passwordCounter == 4)
                {
                    newUser.setUsername("");
                    newUser.setPassword("");
                    System.out.println("Sorry, you have entered wrong password too many times");
                    break;
                }
                if (user.getPassword().equals(newUser.getPassword()))
                {
                    break;
                }
                ++i;
            }
            if(i == Database.getUserList().size())
            {
                System.out.println("Invalid username");
                newUser.setUsername("");
                newUser.setPassword("");
            }
        }
        catch (ArrayIndexOutOfBoundsException e)
        {
            System.out.println("Invalid command. Check 'help' for more information!");
        }
        System.out.print("Please enter a command: ");
        cmd = reader.readLine();
        command = cmd.split(" ", 2);

    }

    private void logout() throws IOException
    {
        System.out.println("You have successfully logged out!");
        newUser = null;
        newUser = new User();
        System.out.print("Please enter a command: ");
        cmd = reader.readLine();
        command = cmd.split(" ", 2);
    }


    private void addMovie() throws IOException
    {
        try
        {
            int i = 0;
            boolean alreadyFav = false;
            for(Movie movie: Database.getMovieList())
            {
                if (movie.getTitle().equalsIgnoreCase(command[1])){
                    for(Movie favMovie : newUser.getFavMovies())
                    {
                        if(movie.getTitle().equalsIgnoreCase(favMovie.getTitle()))
                        {
                            alreadyFav = true;
                            System.out.println("Movie already in favourites!");
                            break;
                        }
                    }
                    if(alreadyFav == false)
                    {
                        newUser.addFavMovie(movie);
                        System.out.println("Movie successfully added to your favourites!");
                        break;
                    }
                }
                ++i;
            }
            if (i == Database.getMovieList().size() && alreadyFav == false) {
                System.out.println("Movie not available within our movie database.");
            }
        }
        catch (ArrayIndexOutOfBoundsException e)
        {
            System.out.println("Invalid command. Check 'help' for more information!");
        }

        System.out.print("Please enter a command: ");
        cmd = reader.readLine();
        command = cmd.split(" ", 2);
    }

    private void startMessage() throws IOException
    {
        System.out.println("Hello and welcome to Kaizen's movie app");
        System.out.println("For more information about the funcitons of the app please type in \"help\"\n");
        System.out.print("Please enter a command: ");

        cmd = reader.readLine();
        command = cmd.split(" ", 2);
    }

    private void helpMessage() throws IOException
    {
        System.out.println("List of all commands:");
        System.out.println("Register <Username>: to create a new account");
        System.out.println("Login <Username>: to log inside of your existing account");
        System.out.println("Quit: if you would like to exit the app");
        System.out.println("Add <Movie title>: add a movie to your favourites");
        System.out.println("Favourites: displays user's favourite movies");
        System.out.println("Remove: removes a movie from user's favourites");
        System.out.println("List: displays all movies in our database");
        System.out.println("History: displays all movies a user has watched and when");
        System.out.println("Play: displays actors playing in the movie");
        System.out.println("Actors: displays all actors inside of our database");
        System.out.println("Search <Movie/Actor/Year>: allows you to search via movie name, actor name or year of release");
        System.out.println("Logout: logs user out of their account");
        System.out.println("Help: Displays this message");
        System.out.print("Please enter a command: ");
        cmd = reader.readLine();
        command = cmd.split(" ", 2);
    }

    private void adminAdd() throws IOException
    {
        int i = 0;
        try
        {
            for (Movie movie : Database.getMovieList())
            {
                if (command[1].equalsIgnoreCase(movie.getTitle())) {
                    System.out.println(command[1] + " already exists!");
                    break;
                }
                ++i;
            }
            if (i == Database.getMovieList().size())
            {
                String actorName;
                String movieName;
                ArrayList<Actor> cast = new ArrayList<>();
                for(int j = 0; j < 3 ; ++j)
                {
                    boolean isInList = false;
                    System.out.print("Enter actor's real name: ");
                    cmd = reader.readLine();
                    actorName = cmd;
                    System.out.print("Enter actor's movie name: ");
                    cmd = reader.readLine();
                    movieName = cmd;
                    Actor actor = new Actor(actorName, movieName);
                    for(Actor actorInList : Database.getActorList())
                    {
                        if(actorInList.getName().equals(actor.getName()))
                        {
                            System.out.println("Actor is in Database");
                            isInList = true;
                            break;
                        }
                    }
                    if(isInList == false)
                    {
                        System.out.println("Added actor in Database");
                        Database.addActor(actor);
                    }
                    cast.add(actor);
                }
                System.out.print("Enter release year: ");
                int releaseYear;
                do
                {
                    System.out.println("Release year cannot be before 1878");
                    cmd = reader.readLine();
                    releaseYear = Integer.parseInt(cmd);
                }
                while(releaseYear < 1878);
                Movie movie = new Movie(command[1], cast, releaseYear);
                Database.addMovie(movie);
                System.out.println("Added " + command[1] + " to movie list!");
            }
        }
        catch (ArrayIndexOutOfBoundsException e)
        {
            System.out.println("Invalid command. Check 'help' for more information!");
        }
        System.out.print("Please enter a command: ");
        cmd = reader.readLine();
        command = cmd.split(" ", 2);

    }

    private void adminRemove() throws IOException
    {
        boolean movieFound = false;
        try
        {
            for (Movie movie : Database.getMovieList())
            {
                if (command[1].equalsIgnoreCase(movie.getTitle()))
                {
                    Database.getMovieList().remove(movie);
                    movieFound = true;
                    System.out.println("Deleting " + command[1]);
                    Database.saveDatabase();
                    break;

                }
            }
            if(movieFound == false)
            {
                System.out.println("Selected movie is not in the list. Try again.");
            }
        }
        catch (ArrayIndexOutOfBoundsException e)
        {
            System.out.println("Invalid command. Check 'help' for more information!");
        }
        System.out.print("Please enter a command: ");
        cmd = reader.readLine();
        command = cmd.split(" ", 2);
    }

    private void listMovies() throws IOException
    {
        for (Movie movie : Database.getMovieList())
        {
            System.out.println(movie.getTitle());
        }
        System.out.print("Please enter a command: ");
        cmd = reader.readLine();
        command = cmd.split(" ", 2);
    }

    public void play()throws IOException{
        boolean movieFound = false;
        try
        {
            for (Movie movie : Database.getMovieList() )
            {
                if (movie.getTitle().equalsIgnoreCase(command[1]))
                {
                    movie.playMovie();
                    movieFound = true;
                    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/uuuu");
                    LocalDate localDate = LocalDate.now();
                    History history = new History(movie, localDate);
                    newUser.addToHistory(history);
                    break;
                }
            }
            if (movieFound == false)
            {
                System.out.println("No such movie");
            }

        }
        catch (ArrayIndexOutOfBoundsException e)
        {
            System.out.println("Invalid command. Check 'help' for more information!");
        }
        System.out.print("Please enter a command: ");
        cmd = reader.readLine();
        command = cmd.split(" ", 2);
    }

    public void removeMovie() throws IOException{
        try
        {
            boolean movieFound = false;
            for(Movie movie : newUser.getFavMovies()){
                if(command[1].equalsIgnoreCase(movie.getTitle()))
                {
                    newUser.removeMovie(movie);
                    movieFound = true;
                    System.out.println("Movie successfully removed from favorites.");
                    break;
                }
            }
            if(movieFound == false)
            {
                System.out.println("Movie not found in favorites.");
            }
        }
        catch (ArrayIndexOutOfBoundsException e)
        {
            System.out.println("Invalid command. Check 'help' for more information!");
        }
        System.out.print("Please enter a command: ");
        cmd = reader.readLine();
        command = cmd.split(" ", 2);
    }
    public void history() throws IOException
    {
        newUser.displayHistory();

        System.out.print("Please enter a command: ");
        cmd = reader.readLine();
        command = cmd.split(" ", 2);
    }

    public void favourites()throws IOException
    {
        newUser.displayFavourites();

        System.out.print("Please enter a command: ");
        cmd = reader.readLine();
        command = cmd.split(" ", 2);
    }

    public void search() throws IOException
    {
        boolean foundMovie = false;
        try
        {
            for(Movie movie : Database.getMovieList()){
                if(movie.getTitle().toLowerCase().contains(command[1].toLowerCase())
                        || movie.getReleaseYear() == parseIntOrNull(command[1]))
                {
                    foundMovie = true;
                    System.out.println(movie.getTitle());
                }
                for (Actor actor : movie.getCast())
                {
                    if(actor.getName().toLowerCase().contains(command[1].toLowerCase()))
                    {
                        System.out.println(movie.getTitle());
                        foundMovie = true;
                    }
                }
            }
            if(foundMovie == false)
            {
                System.out.println(command[1] + " not found.");
            }
        }
        catch (ArrayIndexOutOfBoundsException e)
        {
            System.out.println("There is an error. Please try again!");
        }
        System.out.print("Please enter a command: ");
        cmd = reader.readLine();
        command = cmd.split(" ", 2);
    }
    
        private void listActors() throws IOException
        {
        for (Actor actor : Database.getActorList())
        {
            System.out.println(actor.getName());
        }
        System.out.print("Please enter a command: ");
        cmd = reader.readLine();
        command = cmd.split(" ", 2);
    }

<<<<<<< HEAD:First Semester/Module 2 Project/Movie app/src/Run.java
    public Integer parseIntOrNull(String value)
    {
        try
        {
            return Integer.parseInt(value);
        }
        catch (NumberFormatException e)
        {
            return 0;
        }
=======
    public void favourites()throws IOException{
        newUser.displayFavourites();

        System.out.print("Please enter a command: ");
        cmd = reader.readLine();
        command = cmd.split(" ", 2);
>>>>>>> da48e9a725cfe649e954bf6a2007c081139ec1b4:Module 2 Project/Movie app/src/Run.java
    }
}
