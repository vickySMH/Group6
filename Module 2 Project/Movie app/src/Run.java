import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Run {
    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static String cmd;
    private static String[] command;
    public static void run() throws IOException
    {
        startMessage();
        while(command[0].compareToIgnoreCase("quit") != 0)
        {
            if(command[0].equalsIgnoreCase("help"))
            {
                helpMessage();
            }
            else if(command[0].equalsIgnoreCase("add"))
            {
                addMovie();
            }
            else if(command[0].equalsIgnoreCase("login"))
            {
                login();
            }
        }
        System.out.println("Thank you for using Kaizen's movie app!");
    }

    private static void login() throws IOException
    {
        int passwordCounter = 0;
        if(command[1] == null)
        {
            System.out.println("Unknown error with username!");
        }
        else
        {
            User.setUsername(command[1]);
        }
        int i = 0;
        for (User user : Database.getUserList())
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
                        System.out.println("You have successfully logged in!");
                        break;
                    }
                    else
                    {
                        ++passwordCounter;
                        System.out.println("You have entered your password incorrectly" + passwordCounter +
                                " times, you are allowed to enter it 3 times incorrectly," +
                                "after this your login will be canceled!");
                    }
                }
                while(passwordCounter < 3);
                }
                if(passwordCounter == 3)
                {
                    User.setUsername(null);
                    User.setPassword(null);
                    System.out.println("Sorry, you have entered wrong password too many times!");
                }
                ++i;
            }
        if(i == Database.getUserList().size())
        {
            System.out.println("Invalid username!");
            User.setUsername(null);
            User.setPassword(null);
        }
        else
        {
            System.out.println("You have successfully logged in!");
        }
    }

    private static void addMovie() throws IOException
    {
        try
        {
            System.out.println(command[1]);
        }
        catch (ArrayIndexOutOfBoundsException e)
        {
            System.out.println("Invalid movie title!");
            cmd = reader.readLine();
            command = cmd.split(" ", 2);
        }
    }

    private static void startMessage() throws IOException
    {
        System.out.println("Hello and welcome to Kaizen's movie app!");
        System.out.println("For more information about the functions of the app please type in \"help\"\n");
        cmd = reader.readLine();
        command = cmd.split(" ", 2);
    }

    private static void helpMessage() throws IOException
    {
        System.out.println("Register: to create a new account");
        System.out.println("Login: to log inside of your existing account");
        System.out.println("Quit: if you would like to exit the app");
        System.out.println("Add <Movie title>: add a movie to your favourites");
        cmd = reader.readLine();
        command = cmd.split(" ", 2);
    }

}
