import javax.xml.crypto.Data;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Run {
    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static String cmd;
    private static String[] command;
    public static void run() throws IOException
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

            if(command[0].equalsIgnoreCase("add") && User.getUsername().equalsIgnoreCase("admin"))
            {
                adminAdd();
            }
            else if(command[0].equalsIgnoreCase("remove") && User.getUsername().equalsIgnoreCase("admin"))
            {
                adminRemove();
            }
                /*else if(command[0].equalsIgnoreCase("delete"))
                {
                    deleteUser();
                }*/

            else if(command[0].equalsIgnoreCase("help"))
            {
                helpMessage();
            }
           /* else if(command[0].equalsIgnoreCase("add"))
            {
                addMovie();
            }*/
            else if(command[0].equalsIgnoreCase("login"))
            {
                login();
            }
            else if(command[0].equalsIgnoreCase("register"))
            {
                register();
            }
            else
            {
                System.out.println("Unknown command.");
                System.out.println("Please enter a command: ");
                cmd = reader.readLine();
                command = cmd.split(" ", 2);
            }
        }
        System.out.println("Thank you for using Kaizen's movie app");
    }

    private static void register() throws IOException{
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

                User.setUsername(command[0]);
            }
            else {
                username = command[1];
                User.setUsername(command[1]);
            }

            int i = 0;
            for(User user : Database.getUserList()){
                if(user.getUsername().equals(User.getUsername())){
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
                User user = new User(username, password);
                Database.addUser(user);
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

    private static void login() throws IOException
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

                User.setUsername(command[0]);
            }
            else
            {
                User.setUsername(command[1]);
            }
            int i = 0;
            for (User user :Database.getUserList())
            {
                if(user.getUsername().equals(User.getUsername()))
                {
                    System.out.print("Please enter password: ");
                    do
                    {
                        cmd = reader.readLine();
                        User.setPassword(cmd);
                        if (user.getPassword().equals(User.getPassword()))
                        {
                            passwordCounter = 4;
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
                    User.setUsername("");
                    User.setPassword("");
                    System.out.println("Sorry, you have entered wrong password too many times");
                    break;
                }
                if (user.getPassword().equals(User.getPassword()))
                {
                    break;
                }
                ++i;
            }
            if(i == Database.getUserList().size())
            {
                System.out.println("Invalid username");
                User.setUsername("");
                User.setPassword("");
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

    private static void addMovie() throws IOException
    {
        try
        {
            System.out.println(command[1]);
        }
        catch (ArrayIndexOutOfBoundsException e)
        {
            System.out.println("Invalid movie title");
        }

        System.out.print("Please enter a command: ");
        cmd = reader.readLine();
        command = cmd.split(" ", 2);
    }

    private static void startMessage() throws IOException
    {
        System.out.println("Hello and welcome to Kaizen's movie app");
        System.out.println("For more information about the funcitons of the app please type in \"help\"\n");
        System.out.print("Please enter a command: ");

        cmd = reader.readLine();
        command = cmd.split(" ", 2);
    }

    private static void helpMessage() throws IOException
    {
        System.out.println("Register <Username>: to create a new account");
        System.out.println("Login <Username>: to log inside of your existing account");
        System.out.println("Quit: if you would like to exit the app");
        System.out.println("Add <Movie title>: add a movie to your favourites");
        System.out.print("Please enter a command: ");
        cmd = reader.readLine();
        command = cmd.split(" ", 2);
    }

    private static void adminAdd() throws IOException
    {
        int i = 1;
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
            if (i == Database.getUserList().size())
            {
                Movie movie = new Movie(command[1]);
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

    private static void adminRemove() throws IOException
    {
        int i = 1;
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

}
