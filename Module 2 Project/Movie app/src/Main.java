import java.io.IOException;

public class Main {
    public static void main(String[] args) {

        try
        {
            Run.run();
        }
        catch (IOException e)
        {
            System.out.println("Unknown error");
        }
    }
}
