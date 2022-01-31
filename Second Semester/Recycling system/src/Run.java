import java.util.Scanner;

public class Run
{
    public static void main(String[] args)
    {
        work();
    }

    public static void work()
    {
        Scanner scanner = new Scanner(System.in);
        RecyclingMachine recyclingMachine =  new RecyclingMachine();
        char typeOfPant;
        do
        {
            System.out.print("Please deposit bottles: ");
            typeOfPant = scanner.next().charAt(0);
            typeOfPant = Character.toUpperCase(typeOfPant);
            Can.typeOfPant(typeOfPant);
        }
        while(typeOfPant != 'O');
        recyclingMachine.receipt();
        work();
    }
}
