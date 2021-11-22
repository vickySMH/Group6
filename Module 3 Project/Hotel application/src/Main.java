import java.io.IOException;

public class Main
{
    public static void main(String[] args)
    {
        Run run = new Run();
        try
        {
            run.run();
        }
        catch (IOException e)
        {
            System.out.println("Error entering a command please, try again!");
        }
    }
}
