import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Run {
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
            else
            {
                System.out.println("Unknown command or you must be logged in to use it.");
                System.out.println("Please enter a command: ");
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
                do{
                    System.out.println("You need to enter a new username");
                    cmd = reader.readLine();
                    command = cmd.split(" ", 2);
                    username = command[0];
                }
                while(command[0] == null || command[0].length() < 4 || command[0].length() > 20);

                newUser.setUsername(command[0]);
            }
            else {
                username = command[1];
                newUser.setUsername(command[1]);
            }

            int i = 0;
            for(User user : Database.getUserList()){
                if(user.getUsername().equals(newUser.getUsername())){
                    System.out.println("Username already exists!");
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
                do{
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
            for (User user :Database.getUserList())
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
                            passwordCounter = 4;
                            newUser = user;
                            System.out.println("You have successfully logged in!");
                            break;
                        }
                        else
                        {
                            ++passwordCounter;
                            System.out.println("You have entered your password incorrectly" + passwordCounter +
                                    " times, you are allowed to enter it 3 times incorrectly," +
                                    "after this your login will be canceled");
                        }
                    }
                    while(passwordCounter < 3);
                }
                if(passwordCounter == 3)
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
        newUser.setUsername("");
        newUser.setPassword("");
        System.out.print("Please enter a command: ");
        cmd = reader.readLine();
        command = cmd.split(" ", 2);
    }


    private void addMovie() throws IOException
    {
        try
        {
            int i = 0;
            for(Movie movie: Database.getMovieList()) {
                if (movie.getTitle().equalsIgnoreCase(command[1])){
                    newUser.addFavMovie(movie);
                    System.out.println("Movie successfully added to your favourites!");
                    break;
                }
                ++i;
            }
            if (i == Database.getMovieList().size()) {
                System.out.println("Movie not available within our movie database.");
            }
        }
        catch (ArrayIndexOutOfBoundsException e)
        {
            System.out.println("Invalid movie title");
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
        System.out.println("Register <Username>: to create a new account");
        System.out.println("Login <Username>: to log inside of your existing account");
        System.out.println("Quit: if you would like to exit the app");
        System.out.println("Add <Movie title>: add a movie to your favourites");
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
                    System.out.print("Enter actor's real name: ");
                    cmd = reader.readLine();
                    actorName = cmd;
                    System.out.print("Enter actor's movie name: ");
                    cmd = reader.readLine();
                    movieName = cmd;
                    Actor actor = new Actor(actorName, movieName);
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
            System.out.println("Invalid movie title!");
        }
        System.out.print("Please enter a command: ");
        cmd = reader.readLine();
        command = cmd.split(" ", 2);

    }

    private void adminRemove() throws IOException
    {
        int i = 0;
        try
        {
            for (Movie movie : Database.getMovieList())
            {
                if (command[1].equalsIgnoreCase(movie.getTitle()))
                {
                    Database.getMovieList().remove(movie);
                    System.out.println("Deleting " + command[1]);
                    Database.saveDatabase();
                    break;

                }
                ++i;
            }
            if(i == Database.getMovieList().size())
            {
                System.out.println("Selected movie is not in the list. Try again.");
            }
        }
        catch (ArrayIndexOutOfBoundsException e)
        {
            System.out.println("Invalid movie title!");
        }
        System.out.print("Please enter a command: ");
        cmd = reader.readLine();
        command = cmd.split(" ", 2);
    }

    private void listMovies() throws IOException {
        try{
            for (Movie movie : Database.getMovieList()){
                System.out.println(movie.getTitle());
            }
        }
        catch (Exception e){
            System.out.println("Error listing the movies. Try again");
        }
        System.out.print("Please enter a command: ");
        cmd = reader.readLine();
        command = cmd.split(" ", 2);
    }

    public void play()throws IOException{
        int i = 0;
        try {
            for (Movie movie : Database.getMovieList() ){
                if (movie.getTitle().equalsIgnoreCase(command[1])){
                    movie.playMovie();
                    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/uuuu");
                    LocalDate localDate = LocalDate.now();
                    History history = new History(movie, localDate);
                    newUser.addToHistory(history);
                    break;

                }
                ++i;
            }
            if (i == Database.getMovieList().size()){
                System.out.println("No such movie");
            }

        }
        catch (ArrayIndexOutOfBoundsException e){
            System.out.println("Invalid movie title");
        }
        System.out.print("Please enter a command: ");
        cmd = reader.readLine();
        command = cmd.split(" ", 2);
    }

    public void removeMovie() throws IOException{
        try{
            int i = 0;
            for(Movie movie : newUser.getFavMovies()){
                if(command[1].equalsIgnoreCase(movie.getTitle())){
                    newUser.removeMovie(movie);
                    System.out.println("Movie successfully removed from favorites.");
                    break;
                }
                ++i;
            }
            if(i == newUser.getFavMovies().size()){
                System.out.println("Movie not found in favorites.");
            }
        }
        catch (ArrayIndexOutOfBoundsException e){
            System.out.println("Invalid movie title.");
        }
        System.out.print("Please enter a command: ");
        cmd = reader.readLine();
        command = cmd.split(" ", 2);
    }
    public void history() throws IOException
    {
        try
        {
            newUser.displayHistory();
        }
        catch (ArrayIndexOutOfBoundsException e){
        System.out.println("Invalid movie title.");
    }
        System.out.print("Please enter a command: ");
        cmd = reader.readLine();
        command = cmd.split(" ", 2);
    }
}
