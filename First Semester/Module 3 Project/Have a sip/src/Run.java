import Beverages.Soda;

public class Run
{
    public static void main(String[] args)
    {
        Soda soda = new Soda("Coke", 500, "Brown");

        soda.drinkASip(600);
        soda.drinkASip(500);
        System.out.println(soda.getMililiters());
    }
}
