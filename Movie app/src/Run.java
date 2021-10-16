import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Run {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    String cmd;
    String[] command;
    public void run() throws IOException
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
        }
        System.out.println("Thank you for using Kaizen's movie app");
    }

    public void addMovie() throws IOException
    {
        try
        {
            System.out.println(command[1]);
        }
        catch (ArrayIndexOutOfBoundsException e)
        {
            System.out.println("Invalid movie title");
            cmd = reader.readLine();
            command = cmd.split(" ", 2);
        }
    }

    public void startMessage() throws IOException
    {
        System.out.println("Hello and welcome to Kaizen's movie app");
        System.out.println("For more information about the funcitons of the app please type in \"help\"\n");
        cmd = reader.readLine();
        command = cmd.split(" ", 2);
    }

    public void helpMessage() throws IOException
    {
        System.out.println("Register: to create a new account");
        System.out.println("Login: to log inside of your existing account");
        System.out.println("Quit: if you would like to exit the app");
        System.out.println("Add <Movie title>: add a movie to your favourites");
        cmd = reader.readLine();
        command = cmd.split(" ", 2);
    }

}
