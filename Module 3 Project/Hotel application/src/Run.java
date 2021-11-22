import People.Staff;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Run
{

    private BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private String cmd;
    private Staff staff = new Staff();
    private String[] command;

    public void run() throws IOException
    {

        try
        {
            Database.loadStaff();
        }
        catch(Exception e)
        {
            System.out.println("Error loading from database!");
        }

        startMessage();
        while(command[0].compareToIgnoreCase("quit") != 0)
        {
                if(command[0].equalsIgnoreCase("staff")
                        && staff.getTitle().equalsIgnoreCase("manager"))
                {
                    for(Staff personel : Database.getStaff())
                    {
                        System.out.println(personel);
                    }
                }
                if(command[0].equalsIgnoreCase("help"))
                {

                }
                else
                {
                    System.out.println("Unknown command, please check \'help \' for list of commands");
                    cmd = reader.readLine();
                    command = cmd.split(" ", 2);
                    break;
                }
            }
        System.out.println("Thank you for using Kaizen's hotel app!");
    }

    public void startMessage() throws IOException
    {
        System.out.println("Welcome to Kaizen's hotel app! " + "\n" +
                "For more information please, type in \'help\'!");
        cmd = reader.readLine();
        command = cmd.split(" ", 2);
    }

    public void helpMessage() throws IOException
    {
        System.out.println("help message");
        cmd = reader.readLine();
        command = cmd.split(" ", 2);
    }

}
