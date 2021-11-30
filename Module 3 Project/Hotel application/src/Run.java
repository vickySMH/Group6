import People.Employee;
import People.User;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Run
{

    private BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private String cmd;
    private Employee user = new Employee();

    private String[] command;

    public void run() throws IOException
    {
        startMessage();
        while (!command[0].equalsIgnoreCase("quit"))
        {
            if (command[0].equalsIgnoreCase("remove"))
            {
                command = cmd.split(" ", 3);
                try
                {
                    if (command[1].equalsIgnoreCase("staff") && user.getTitle().equalsIgnoreCase("manager"))
                    {
                        removeStaff();
                    }
                    else if (command[1].equalsIgnoreCase("room") && user.getTitle().equalsIgnoreCase("manager"))
                    {
                        removeRoom();
                    }
                    else
                    {
                        System.out.println("Unknown command, please check 'help ' for list of commands");
                    }
                }
                catch (ArrayIndexOutOfBoundsException e)
                {
                    System.out.println("Unknown command, please check 'help ' for list of commands");
                }
                System.out.print("Please enter a command: ");
                cmd = reader.readLine();
                command = cmd.split(" ", 2);
            }
            else if (command[0].equalsIgnoreCase("accounts"))
            {
                accounts();
            }
            else if (command[0].equalsIgnoreCase("staff")
                    && user.getTitle().equalsIgnoreCase("manager"))
            {
                for (Employee personel : Database.getStaff())
                {
                    System.out.println(personel);
                }
                System.out.print("Please enter a command: ");
                cmd = reader.readLine();
                command = cmd.split(" ", 2);
            }
            else if (command[0].equalsIgnoreCase("change"))
            {
                command = cmd.split(" ", 3);
                if (command[1].equalsIgnoreCase("staff"))
                {
                    changeStaff();
                }
                else if (command[1].equalsIgnoreCase("room"))
                {
                    changeRoom();
                }
                else
                {
                    System.out.println("Unknown command, please check 'help ' for list of commands");
                }
                System.out.print("Please enter a command: ");
                cmd = reader.readLine();
                command = cmd.split(" ", 2);
            }
            else if (command[0].equalsIgnoreCase("rooms") &&
                    (user.getTitle().equalsIgnoreCase("manager")
                            || user.getTitle().equalsIgnoreCase("receptionist")))
            {
                for (Room room : Database.getRooms())
                {
                    //System.out.println(room);
                    room.printRoom();
                }
                System.out.print("Please enter a command: ");
                cmd = reader.readLine();
                command = cmd.split(" ", 2);
            }
            else if (command[0].equalsIgnoreCase("login") && user.getUsername().isBlank())
            {
                login();
            }
            else if (command[0].equalsIgnoreCase("logout") && !user.getUsername().isBlank())
            {
                logout();
            }
            else if (command[0].equalsIgnoreCase("help"))
            {
                helpMessage();
            }
            else if (command[0].equalsIgnoreCase("dirty") && user.getTitle().equalsIgnoreCase("cleaner"))
            {
                dirty();
            }
            else if (command[0].equalsIgnoreCase("clean") && user.getTitle().equalsIgnoreCase("cleaner"))
            {
                clean();
            }
            else if (command[0].equalsIgnoreCase("password") && !user.getUsername().isBlank())
            {
                password();
            }
            else if (command[0].equalsIgnoreCase("add"))//&& user.getTitle().equalsIgnoreCase("manager"))
            {
                command = cmd.split(" ", 3);
                if (command[1].equalsIgnoreCase("staff"))
                {
                    addStaff();
                }
                else if (command[1].equalsIgnoreCase("room"))
                {
                    addRoom();
                }
                else
                {
                    System.out.println("Unknown command, please check 'help ' for list of commands");
                    System.out.print("Please enter a command: ");
                    cmd = reader.readLine();
                    command = cmd.split(" ", 2);
                }
            }
            else if (command[0].equalsIgnoreCase("payroll") && (user.getTitle().equalsIgnoreCase("manager")
                    || user.getTitle().equalsIgnoreCase("accountant"))) {
                payroll();
            }
            else if (command[0].equalsIgnoreCase("tax") && (user.getTitle().equalsIgnoreCase("manager")
                    || user.getTitle().equalsIgnoreCase("accountant"))) {
                tax();
            }
            else if (command[0].equalsIgnoreCase("income") && (user.getTitle().equalsIgnoreCase("manager")
                    || user.getTitle().equalsIgnoreCase("accountant"))) {
                System.out.println("Income: " + income() + " dkk.");
                System.out.print("Please enter a command: ");
                cmd = reader.readLine();
                command = cmd.split(" ", 2);
            }
            else if (command[0].equalsIgnoreCase("budget") && (user.getTitle().equalsIgnoreCase("manager")
                    || user.getTitle().equalsIgnoreCase("accountant")))
            {
                System.out.println("Budget: " + budget() + " dkk.");
                System.out.print("Please enter a command: ");
                cmd = reader.readLine();
                command = cmd.split(" ", 2);
            }
            else if (command[0].equalsIgnoreCase("book") && user.getTitle().equalsIgnoreCase("receptionist"))
            {
                book();
            }
            else
            {
                System.out.println("Unknown command, please check 'help ' for list of commands");
                System.out.print("Please enter a command: ");
                cmd = reader.readLine();
                command = cmd.split(" ", 2);
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
            for (Room room : Database.getRooms())
            {
                if (roomNumber == room.getRoomNumber())
                {
                    if (room.isClean() == false) {
                        room.cleanRoom(true);
                        System.out.println("Room is now clean, thank you for doing such an amazing job!");
                    }
                }
            }
        } catch (NumberFormatException e)
        {
            System.out.println("You have added a letter to the room number, please try using the command again");
            clean();
        }
        System.out.print("Please enter a command: ");
        cmd = reader.readLine();
        command = cmd.split(" ", 2);
    }

    private void password() throws IOException
    {
        String password;
        System.out.print("Please enter your old password: ");
        cmd = reader.readLine();
        command = cmd.split(" ", 2);
        if (command[0].equalsIgnoreCase(user.getPassword()))
        {
            System.out.print("Please enter a new password: ");
            cmd = reader.readLine();
            command = cmd.split(" ", 2);
            password = command[0];
            do
            {
                System.out.println("If you feel like you have mistyped your password please enter 'reset'");
                System.out.print("Please confirm your password: ");
                cmd = reader.readLine();
                if (cmd.equalsIgnoreCase("reset"))
                {
                    break;
                }
            }
            while (!password.equals(cmd));
            if (cmd.equalsIgnoreCase("reset"))
            {
                password();
            }
            else
            {
                for (Employee user1 : Database.getStaff())
                {
                    if (user1.getUsername().equals(user.getUsername()))
                    {
                        user1.setPassword(password);
                        Database.saveDatabase();
                    }
                }
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

    private void helpMessage() throws IOException
    {
        if (user.getTitle().isBlank())
        {
            System.out.println("Please log in your account to see the commands appropriate for your job");
        }
        if (user.getTitle().equalsIgnoreCase("manager"))
        {
            System.out.println("Rooms - displays all rooms in the hotel and if they are taken or not");
            System.out.println("Staff - displays all of the staff working in the hotel");
            System.out.println("Add - displays a message asking if you would like to add a room or staff");
            System.out.println("Remove - displays a message asking if you would like to remove a room or staff");
            System.out.println("Change - displays a message asking if you would like to change a room or staff");
            System.out.println("Payroll - checks staff's salaries");
            System.out.println("Dirty - displays all of the dirty rooms in the hotel");
            System.out.println("Bookings - displays all booked rooms");
            System.out.println("Accounts - displays all accounts and passwords");
            System.out.println("Password - gives you the opportunity to change password");
        }

        if (user.getTitle().equalsIgnoreCase("cleaner"))
        {
            System.out.println("Clean - marks room as no longer dirty");
            System.out.println("Dirty - displays all of the dirty rooms in the hotel");
            System.out.println("Password - gives you the opportunity to change password");
        }

        if (user.getTitle().equalsIgnoreCase("receptionist"))
        {
            System.out.println("Book - books a room for a customer");
            System.out.println("Change - changes a booking for a customer");
            System.out.println("Remove - removes a booking for a customer");
            System.out.println("Bookings - displays all booked rooms");
            System.out.println("Password - gives you the opportunity to change password");
        }

        if (user.getTitle().equalsIgnoreCase("accountant"))
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
        catch (Exception e)
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
        if (user.getTitle().equalsIgnoreCase("cleaner"))
        {
            try
            {
                boolean noDirtyRooms = true;
                for (Room room : Database.getRooms())
                {
                    if (room.isClean())
                    {
                        System.out.println("Room " + room.getRoomNumber() + " is clean!");
                    }
                    else
                    {
                        System.out.println("Room " + room.getRoomNumber() + " needs cleaning!");
                        noDirtyRooms = false;
                    }
                }
                if (noDirtyRooms)
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

    public void addStaff() throws IOException
    {
        String firstName, lastName, title, phoneNumber;
        int salary;
        boolean isRegistered = false;
        System.out.print("Please enter phone number: ");
        cmd = reader.readLine();
        command = cmd.split(" ", 2);
        phoneNumber = command[0];
        for (Employee staff1 : Database.getStaff())
        {
            if (staff1.getPhoneNumber().equalsIgnoreCase(phoneNumber))
            {
                isRegistered = true;
                System.out.println("Person already registered as staff!");
            }
        }
        System.out.print("Please enter first name: ");
        cmd = reader.readLine();
        command = cmd.split(" ", 2);
        firstName = command[0];
        System.out.print("Please enter last name: ");
        cmd = reader.readLine();
        command = cmd.split(" ", 2);
        lastName = command[0];
        title = title();
        System.out.print("Please enter salary: ");
        cmd = reader.readLine();
        command = cmd.split(" ", 2);
        try
        {
            salary = Integer.parseInt(command[0]);
        }
        catch (NumberFormatException e)
        {
            System.out.println("Error with salary. Automatically setting salary to default");
            salary = 17000;
        }
        User newUser = register();
        if (isRegistered == false)
        {
                System.out.println("Successfully registered " + firstName + " " + lastName + " as " + title);
                System.out.println("Account for " + firstName + " " + lastName + ": " + newUser.getUsername()
                        + " with temporary password: " + newUser.getPassword());
                Employee stafff = new Employee(firstName, lastName, title, phoneNumber, salary, newUser);
                Database.addStaff(stafff);
        }
        System.out.print("Please enter a command: ");
        cmd = reader.readLine();
        command = cmd.split(" ", 2);
    }

    private void login() throws IOException
    {
        command = cmd.split(" ", 3);
        boolean success = false;
        int passwordSuccess = 0;
        try
        {
            for (Employee user1 : Database.getStaff())
            {
                if (user1.getUsername().equals(command[1]))
                {
                    user.setUsername(command[1]);
                    do
                    {
                        System.out.print("Please enter your password: ");
                        cmd = reader.readLine();
                        command = cmd.split(" ", 2);
                        if (user1.getPassword().equals(command[0]))
                        {
                            success = true;
                            System.out.println("Successfully logged in!");
                            user = user1;
                            break;
                        }
                        else
                        {
                            passwordSuccess++;
                            int timesLeft = 3 - passwordSuccess;
                            if (timesLeft > 1) {
                                System.out.println("You have entered your password incorrectly " + passwordSuccess
                                        + " times, you have " + timesLeft + " remaining tries.");
                            }
                            else if (timesLeft == 1)
                            {
                                System.out.println("You have entered your password incorrectly " + passwordSuccess
                                        + " times, you have " + timesLeft + " remaining try.");
                            }
                        }
                    }
                    while (passwordSuccess < 3);
                    if (passwordSuccess == 3)
                    {
                        user.setUsername("");
                        user.setPassword("");
                        System.out.println("You have entered your password too many times! " +
                                "In case you have forgotten your password please check in with the manager");
                    }
                }
                if(success)
                {
                    break;
                }
            }
            if (!success)
            {
                System.out.println("Unknown user, please try again.");
            }
        }
        catch (ArrayIndexOutOfBoundsException e)
        {
            System.out.println("Unknown command, please check 'help ' for list of commands");
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
        for (int i = 1; i < 5; i++)
        {
            Room room = new Room(2, true, 420, 300 + i);
            Database.addRoom(room);
        }
        for (int i = 1; i < 3; i++)
        {
            Room room = new Room(4, true, 900, 304 + i);
            Database.addRoom(room);
        }
    }*/

    public void addRoom() throws IOException
    {
        int numOfBeds, pricePerNight, roomNum;
        boolean hasNet = false;
        boolean roomExists = false;

        System.out.print("Please enter room number: ");
        cmd = reader.readLine();
        command = cmd.split(" ", 2);
        try
        {
            roomNum = Integer.parseInt(command[0]);
            for (Room room : Database.getRooms())
            {
                if (room.getRoomNumber() == roomNum)
                {
                    roomExists = true;
                    throw new NumberFormatException();
                }
            }
            if (roomExists == false)
            {
                System.out.print("Please enter number of beds: ");
                cmd = reader.readLine();
                command = cmd.split(" ", 2);
                try
                {
                    numOfBeds = Integer.parseInt(command[0]);
                }
                catch (NumberFormatException e)
                {
                    System.out.println("You have mistyped the number of beds. " +
                            "Automatically setting the beds to 2.");
                    numOfBeds = 2;
                }
                System.out.print("Does the room have internet connection: ");
                cmd = reader.readLine();
                command = cmd.split(" ", 2);
                if (command[0].equalsIgnoreCase("yes"))
                {
                    hasNet = true;
                }
                else if (command[0].equalsIgnoreCase("no"))
                {
                    hasNet = false;
                }
                else
                {
                    System.out.println("Invalid command. Automatically making the room without internet access.");
                    hasNet = false;
                }
                System.out.print("Please enter price per night for the room: ");
                cmd = reader.readLine();
                command = cmd.split(" ", 2);
                try
                {
                    pricePerNight = Integer.parseInt(command[0]);
                }
                catch (NumberFormatException e)
                {
                    System.out.println("Invalid number. " + "Room price set to default");
                    pricePerNight = 420;
                }
                System.out.println("Successfully added room!");
                Room room = new Room(numOfBeds, hasNet, pricePerNight, roomNum);
                Database.addRoom(room);
            }
        }
        catch (NumberFormatException e)
        {
            System.out.println("Invalid room number");
        }
        System.out.print("Please enter a command: ");
        cmd = reader.readLine();
        command = cmd.split(" ", 2);
    }

    private User register() throws IOException
    {
        System.out.print("Please enter a username: ");
        cmd = reader.readLine();
        command = cmd.split(" ", 2);
        User newUser = new User();
        String username;
        if (command[0].length() < 5 || command[0].length() > 16)
        {
            do
            {
                System.out.print("You need to enter a different username: ");
                cmd = reader.readLine();
                command = cmd.split(" ", 2);
                username = command[0];
            }
            while (command[0].length() < 5 || command.length > 16);
            newUser.setUsername(command[0]);
        }
        else
        {
            username = command[0];
            newUser.setUsername(command[0]);
        }
        for (Employee existing : Database.getStaff())
        {
            if (existing.getUsername().equalsIgnoreCase(username))
            {
                System.out.println("Username already exists!");
                user.setUsername("");
                register();
            }
        }
        return newUser;
    }

    public void removeStaff() throws IOException
    {
        boolean removedStaff = false;
        System.out.print("Please enter the phone number of the person: ");
        cmd = reader.readLine();
        command = cmd.split(" ", 2);
        for (Employee employee : Database.getStaff())
        {
            if (employee.getPhoneNumber().equals(command[0]))
            {
                System.out.println("Successfully removed " + employee.getFullName() + "!");
                removedStaff = true;
                Database.getStaff().remove(employee);
                Database.saveDatabase();
                break;
            }
        }
        if (removedStaff == false)
        {
            System.out.println("No such person in hotel staff");
        }
        /*System.out.print("Please enter a command: ");
        cmd = reader.readLine();
        command = cmd.split(" ", 2);*/
    }

    public void removeRoom() throws IOException
    {
        boolean removeRoom = false;
        System.out.print("Please enter the number of the room: ");
        cmd = reader.readLine();
        command = cmd.split(" ", 2);
        for (Room room : Database.getRooms())
        {
            try
            {
                if (room.getRoomNumber() == Integer.parseInt(command[0]))
                {
                    Database.getRooms().remove(room);
                    Database.saveDatabase();
                    break;
                }
            }
            catch (NumberFormatException e)
            {
                removeRoom();
            }
        }
        if (!removeRoom)
        {
            System.out.println("No such room in hotel!s");
        }
    }

    public void changeStaff() throws IOException
    {
        String phoneNumber;
        System.out.print("Please enter the phone number of the person: ");
        cmd = reader.readLine();
        command = cmd.split(" ", 2);
        phoneNumber = command[0];
        for (Employee name : Database.getStaff())
        {
            if (name.getPhoneNumber().equals(phoneNumber))
            {
                System.out.println(name);
                System.out.print("What would you like to change: ");
                cmd = reader.readLine();
                command = cmd.split(" ", 2);
                if (command[0].equalsIgnoreCase("phone"))
                {
                    System.out.print("Please enter new phone number: ");
                    cmd = reader.readLine();
                    command = cmd.split(" ", 2);
                    name.setPhoneNumber(command[0]);
                    System.out.println("Phone number successfully changed");
                    Database.saveDatabase();
                }
                else if (command[0].equalsIgnoreCase("name"))
                {
                    System.out.print("Please enter new first name: ");
                    cmd = reader.readLine();
                    command = cmd.split(" ", 2);
                    name.setFullName(command[0]);
                    System.out.println("Name successfully changed");
                    Database.saveDatabase();
                }
                else if (command[0].equalsIgnoreCase("position"))
                {
                    System.out.print("Please enter new position: ");
                    cmd = reader.readLine();
                    command = cmd.split(" ", 2);
                    name.setTitle(command[0]);
                    System.out.println("Position successfully changed");
                    Database.saveDatabase();
                }
                else if (command[0].equalsIgnoreCase("salary"))
                {
                    int salary = salary(name);
                    name.setSalary(salary);
                    Database.saveDatabase();
                }
            }
        }
        System.out.print("Please enter a command: ");
        cmd = reader.readLine();
        command = cmd.split(" ", 2);
    }

    public void changeRoom() throws IOException
    {
        int roomNum;
        boolean roomExists;
        System.out.print("Please enter room number: ");
        cmd = reader.readLine();
        command = cmd.split(" ", 2);
        try
        {
            roomNum = Integer.parseInt(command[0]);
            roomExists = roomChange(roomNum);
            if (roomExists == false)
            {
                throw new NumberFormatException();
            }
        }
        catch (NumberFormatException e)
        {
            System.out.println("Invalid room, please enter room number again");
            changeRoom();
        }
        /*System.out.print("Please enter a command: ");
        cmd = reader.readLine();
        command = cmd.split(" ", 2);*/
    }

    private int roomNumber(Room number) throws IOException
    {
        int roomNum = 0;
        System.out.print("Please enter new room number: ");
        cmd = reader.readLine();
        command = cmd.split(" ", 2);
        try
        {
            roomNum = Integer.parseInt(command[0]);
            System.out.println("Room number successfully changed");
            Database.saveDatabase();
        }
        catch (NumberFormatException e)
        {
            System.out.println("Invalid number, please enter room number again");
            roomNumber(number);
        }
        return roomNum;
    }

    private int numOfBeds(Room beds) throws IOException
    {
        int bedsNum = 2;
        System.out.print("What is the new number of beds for this room: ");
        cmd = reader.readLine();
        command = cmd.split(" ", 2);
        try
        {
            bedsNum = Integer.parseInt(command[0]);
            System.out.println("Number of beds successfully changed");
            Database.saveDatabase();
        }
        catch (NumberFormatException e)
        {
            System.out.println("Invalid number, please enter the number beds again");
            numOfBeds(beds);
        }
        return bedsNum;
    }

    private int pricePerNight(Room price) throws IOException
    {
        int priceNight = 420;
        System.out.print("What is the new price per night: ");
        cmd = reader.readLine();
        command = cmd.split(" ", 2);
        try
        {
            priceNight = Integer.parseInt(command[0]);
            System.out.println("Price successfully changed");
            Database.saveDatabase();
        }
        catch (NumberFormatException e)
        {
            System.out.println("Invalid number, please enter the price again");
            pricePerNight(price);
        }
        return priceNight;
    }


    private int salary(Employee name) throws IOException
    {
        int salary = 17000;
        System.out.print("Please enter new salary: ");
        cmd = reader.readLine();
        command = cmd.split(" ", 2);
        try
        {
            salary = Integer.parseInt(command[0]);
            System.out.print("Salary successfully changed");
            Database.saveDatabase();
        }
        catch (NumberFormatException e)
        {
            System.out.println("Invalid amount" + ", please enter salary again");
            salary(name);
        }
        return salary;
    }

    private void logout() throws IOException
    {
        System.out.println("Successfully logged out!");
        Employee user1 = new Employee();
        user = user1;
        System.out.print("Please enter a command: ");
        cmd = reader.readLine();
        command = cmd.split(" ", 2);
    }

    private String title() throws IOException
    {
        String title;
        System.out.print("Please enter position: ");
        cmd = reader.readLine();
        command = cmd.split(" ", 2);
        if (command[0].equalsIgnoreCase("cleaner"))
        {
            title = command[0];
        }
        else if (command[0].equalsIgnoreCase("manager")) {
            title = command[0];
        }
        else if (command[0].equalsIgnoreCase("receptionist")) {
            title = command[0];
        }
        else if (command[0].equalsIgnoreCase("accountant")) {
            title = command[0];
        }
        else
        {
            System.out.println("No such position in hotel!");
            title = title();
        }
        return title;
    }

    private void accounts() throws IOException
    {
        Database.accounts();
        System.out.print("Please enter a command: ");
        cmd = reader.readLine();
        command = cmd.split(" ", 2);
    }


    private void payroll() throws IOException
    {
        System.out.println("Loading employee's salary information....");
        for (Employee staff1 : Database.getStaff())
        {
            System.out.println(staff1.getFullName() + "(" + staff1.getTitle() + ")" + ": " + staff1.getSalary());
        }
        System.out.print("Please enter a command: ");
        cmd = reader.readLine();
        command = cmd.split(" ", 2);
    }

    private int income() throws IOException
    {
        int calculateIncome = 0;
        for (Room room : Database.getRooms())
        {
            calculateIncome += room.getPricePerNight() * 200;
        }

        calculateIncome -= budget();
        return calculateIncome;
    }

    private void tax() throws IOException
    {
        double tax = 0;
        tax = income() * 0.45;
        System.out.println("The taxes are: " + tax + " dkk.");
        System.out.print("Please enter a command: ");
        cmd = reader.readLine();
        command = cmd.split(" ", 2);

    }

    private int budget() throws IOException
    {
        int budget = 0;

        for (Employee employee : Database.getStaff())
        {
            budget += employee.getSalary() * 12;
        }
        budget += 55000;
        return budget;
    }

    private void book() throws IOException
    {
        String phoneNumber, firstName, lastName;
        System.out.print("How many people are you booking: ");
        cmd = reader.readLine();
        command = cmd.split(" ", 2);
        int people;
        try
        {
            people = Integer.parseInt(command[0]);
            for (Room room : Database.getRooms())
            {
                if (room.getNumOfBeds() >= people && room.occupied() == false)
                {
                    System.out.print("The following rooms are available: " + room.getRoomNumber());
                    for (int i = 0; i < people; ++i)
                    {
                        System.out.print("Please enter guest phone number: ");
                        cmd = reader.readLine();
                        command = cmd.split(" ", 2);
                        phoneNumber = command[0];
                        System.out.print("Please enter guest first name: ");
                        cmd = reader.readLine();
                        command = cmd.split(" ", 2);
                        firstName = command[0];
                        System.out.print("Please enter guest last name: ");
                        cmd = reader.readLine();
                        command = cmd.split(" ", 2);
                        lastName = command[0];
                    }
                }
            }
        }
        catch (NumberFormatException e)
        {
            book();
        }
    }

    private void internetAccess(Room room) throws IOException
    {
        System.out.print("Would you like this room to have internet access: ");
        cmd = reader.readLine();
        command = cmd.split(" ", 2);
        if (command[0].equalsIgnoreCase("yes"))
        {
            room.setHasInternetAccess(true);
            System.out.println("Internet access granted to the room");
        }
        else if (command[0].equalsIgnoreCase("no"))
        {
            room.setHasInternetAccess(false);
            System.out.println("Internet access removed");
        }
        else
        {
            internetAccess(room);
        }
    }

    private boolean roomChange(int roomNumber) throws IOException
    {
        boolean roomExists = false;
        for (Room room : Database.getRooms())
        {
            if (room.getRoomNumber() == roomNumber)
            {
                roomExists = true;
                room.printRoom();
                System.out.print("What would you like to change: ");
                cmd = reader.readLine();
                command = cmd.split(" ", 2);
                if (command[0].equalsIgnoreCase("number"))
                {
                    int roomNum = roomNumber(room);
                    room.setRoomNumber(roomNum);
                    Database.saveDatabase();
                }
                else if (command[0].equalsIgnoreCase("internet"))
                {
                    internetAccess(room);
                }
                else if (command[0].equalsIgnoreCase("beds"))
                {
                    int numOfBeds = numOfBeds(room);
                    room.setNumOfBeds(numOfBeds);
                    Database.saveDatabase();
                }
                else if (command[0].equalsIgnoreCase("price"))
                {
                    int pricePerNight = pricePerNight(room);
                    room.setPricePerNight(pricePerNight);
                    Database.saveDatabase();
                }
                else
                {
                    throw new NumberFormatException();
                }
            }
        }
        return roomExists;
    }
}

