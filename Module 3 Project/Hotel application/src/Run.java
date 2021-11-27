import People.Staff;

import javax.xml.crypto.Data;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Run
{

    private BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private String cmd;
    private Staff staff = new Staff();
    private User user = new User();

    private String[] command;

    public void run() throws IOException
    {
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
            else if(command[0].equalsIgnoreCase("help"))
            {
                helpMessage();
            }
            else if(command[0].equalsIgnoreCase("dirty"))
            {
                dirty();
            }
            else if(command[0].equalsIgnoreCase("clean"))
            {
                clean();
            }
            else if(command[0].equalsIgnoreCase("password"))
            {
                password();
            }
            else if (command[0].equalsIgnoreCase("add"))
            {
                if (command[1].equalsIgnoreCase("staff"))
                {
                    addStaff();
                }
            }
            else
            {
                System.out.println("Unknown command, please check 'help ' for list of commands");
                System.out.print("Please enter a command: ");
                cmd = reader.readLine();
                command = cmd.split(" ", 2);
                break;
            }
            Database.saveDatabase();
        }
        System.out.println("Thank you for using Kaizen's hotel app!");
    }

    private void startMessage() throws IOException
    {
        loadDatabase();
        System.out.println("Welcome to Kaizen's hotel app! " + "\n" +
                "For more information please, type in 'help'!");
        System.out.print("Please enter a command: ");
        cmd = reader.readLine();
        command = cmd.split(" ", 2);
    }


    private void clean() throws IOException
    {
        int roomNumber;
        try
        {
            roomNumber = Integer.parseInt(command[1]);
                for(Room room : Database.getRooms())
                {
                    if(roomNumber == room.getRoomNumber())
                    {
                        if(room.isClean() == false)
                        {
                            room.cleanRoom(true);
                            System.out.println("Room is now clean, thank you for doing such an amazing job!");
                        }
                    }
                }
        }
        catch (NumberFormatException e)
        {
            System.out.println("You have added a letter to the room number, please try using the command again");
        }
        System.out.print("Please enter a command: ");
        cmd = reader.readLine();
        command = cmd.split(" ", 2);
    }

    private void password() throws IOException
    {
        String password;
        if(!user.getUsername().isEmpty())
        {
            System.out.print("Please enter your old password: ");
            cmd = reader.readLine();
            if (cmd.equalsIgnoreCase(user.getPassword()))
            {
                System.out.print("Please enter a new password: ");
                cmd = reader.readLine();
                password = cmd;
                do
                {
                    System.out.println("If you feel like you have mistyped your password please enter 'reset'");
                    System.out.print("Please confirm your password: ");
                    cmd = reader.readLine();
                    if(cmd.equalsIgnoreCase("reset"))
                    {
                        break;
                    }
                }
                while (!password.equals(cmd));
                if(cmd.equalsIgnoreCase("reset"))
                {
                    password();
                }
                else
                {
                    user.setPassword(password);
                    System.out.println("Successfully changed password!");
                    System.out.print("Please enter a command: ");
                    cmd = reader.readLine();
                    command = cmd.split(" ", 2);
                }
            }
            else
            {
                System.out.println("Invalid password!");
                System.out.print("Please enter a command: ");
                cmd = reader.readLine();
                command = cmd.split(" ", 2);
            }
        }
    }

    private void helpMessage() throws IOException
    {
        if(staff.getTitle().equalsIgnoreCase("manager"))
        {
            System.out.println("Staff - displays all of the staff working in the hotel");
            System.out.println("Add - displays a message asking if you would like to add a room or staff");
            System.out.println("Remove - displays a message asking if you would like to remove a room or staff");
            System.out.println("Change - displays a message asking if you would like to change a room or staff");
            System.out.println("Payroll - checks staff's salaries");
            System.out.println("Dirty - displays all of the dirty rooms in the hotel");
            System.out.println("Bookings - displays all booked rooms");
            System.out.println("Password - gives you the opportunity to change password");
        }

        if(staff.getTitle().equalsIgnoreCase("cleaner"))
        {
            System.out.println("Clean - marks room as no longer dirty");
            System.out.println("Dirty - displays all of the dirty rooms in the hotel");
            System.out.println("Password - gives you the opportunity to change password");
        }

        if(staff.getTitle().equalsIgnoreCase("receptionist"))
        {
            System.out.println("Book - books a room for a customer");
            System.out.println("Change - changes a booking for a customer");
            System.out.println("Remove - removes a booking for a customer");
            System.out.println("Bookings - displays all booked rooms");
            System.out.println("Password - gives you the opportunity to change password");
        }

        if(staff.getTitle().equalsIgnoreCase("accountant"))
        {
            System.out.println("Income - checks income of hotel");
            System.out.println("Tax - checks taxes that the hotel has to pay");
            System.out.println("Payroll - checks staff's salaries");
            System.out.println("Budget - checks budget for hotel needs");
            System.out.println("Password - gives you the opportunity to change password");
        }
        System.out.print("Please enter a command: ");
        cmd = reader.readLine();
        command = cmd.split(" ", 2);
    }


    private void loadDatabase()
    {
        try
        {
            Database.loadRooms();
        }
        catch(Exception e)
        {
            System.out.println("Error loading from database!");
        }

        try
        {
            Database.loadStaff();
        }
        catch (Exception e)
        {
            System.out.println("Error loading from database!");
        }
        try
        {
            Database.loadGuests();
        }
        catch (Exception e)
        {
            System.out.println("Error loading from database!");
        }
    }

    private void dirty() throws IOException
    {
        if(staff.getTitle().equalsIgnoreCase("cleaner"))
        {
            try
            {
                boolean noDirtyRooms = true;
                for (Room room : Database.getRooms())
                {
                    if (room.isClean())
                    {
                        System.out.println("Room " + room.getRoomNumber() + " is clean!" );
                    }
                    else
                    {
                        System.out.println("Room " + room.getRoomNumber() + " needs cleaning!");
                        noDirtyRooms = false;
                    }
                }
                if(noDirtyRooms)
                {
                    System.out.println("No rooms need cleaning at the moment.");
                }
            }
            catch (ArrayIndexOutOfBoundsException e)
            {
                System.out.println("Invalid command");
            }
        }
        else
        {
            System.out.println("This command is only usable by the cleaner staff");
        }
        System.out.print("Please enter a command: ");
        cmd = reader.readLine();
        command = cmd.split(" ", 2);
    }
    
    public void addStaff() throws IOException {
        String firstName, lastName, title, phoneNumber;
        int ID;
        boolean isRegistered = false;
        try {
            System.out.print("Please enter first name: ");
            cmd = reader.readLine();
            command = cmd.split(" ", 2);
            firstName = command[0];
            System.out.print("Please enter last name: ");
            cmd = reader.readLine();
            command = cmd.split(" ", 2);
            lastName = command[0];
            System.out.print("Please enter position: ");
            cmd = reader.readLine();
            command = cmd.split(" ", 2);
            title = command[0];
            System.out.print("Please enter phone number: ");
            cmd = reader.readLine();
            command = cmd.split(" ", 2);
            phoneNumber = command[0];
            for(Staff staff1: Database.getStaff())
            {
                if(staff1.getPhoneNumber().equalsIgnoreCase(phoneNumber))
                {
                    isRegistered = true;
                    System.out.println("Person already registered as staff!");
                }
            }
            if(isRegistered == false)
            {
                System.out.println("Successfully registered " + firstName + " " + lastName + " as " + title);
                Staff stafff = new Staff(firstName, lastName, title, phoneNumber);
                Database.addStaff(stafff);
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

   /* public void addRooms()
    {
        for (int i = 1; i < 5; i++)
        {
            Room room = new Room(1, false, 200, 100 + i);
            Database.addRoom(room);
        }
        for (int i = 1; i < 9; i++)
        {
            Room room = new Room(2, true, 420, 200 + i);
            Database.addRoom(room);
        }
        for (int i = 1; i < 3; i++)
        {
            Room room = new Room(4, true, 900, 304 + i);
            Database.addRoom(room);
        }
        for (int i = 1; i < 5; i++)
        {
            Room room = new Room(2, true, 420, 300 + i);
            Database.addRoom(room);
        }
    }*/
}
