import java.text.NumberFormat;

public class RecyclingMachine
{
    private static int[] totalCansDeposited = new int[3];
    private static float refunded;

    void receipt()
    {

        System.out.println("Total type 'A' cans: " + totalCansDeposited[0] + "\t Price: DKK "
                + String.format("%.2f", (float) totalCansDeposited[0]));
        System.out.println("Total type 'B' cans: " + totalCansDeposited[1] + "\t Price: DKK "
                + String.format("%.2f", (float) totalCansDeposited[1]*1.5));
        System.out.println("Total type 'C' cans: " + totalCansDeposited[2] + "\t Price: DKK "
                + String.format("%.2f", (float) totalCansDeposited[2]*3));
        System.out.println("Amount received: DKK " +  String.format("%.2f", refunded));
        refunded = 0;
    }

    public static void itterate(char type)
    {
        if (type == 'A')
        {
            ++totalCansDeposited[0];
        }
        else if(type == 'B')
        {
            ++totalCansDeposited[1];
        }
        else
        {
            ++totalCansDeposited[2];
        }
    }

    public static float getRefunded()
    {
        return refunded;
    }

    public static void setRefunded(float refunded)
    {
        RecyclingMachine.refunded = refunded;
    }

    public static void setTotalCansDeposited(int[] totalCansDeposited)
    {
        RecyclingMachine.totalCansDeposited = totalCansDeposited;
    }
}
