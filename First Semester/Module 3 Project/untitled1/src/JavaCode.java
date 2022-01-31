import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.util.Scanner;

public class JavaCode
{
    public static void main(String []args)
    {
        LocalDate localDate = LocalDate.of(2021,1,4);
        LocalDate localDate1;
        try
        {
            Scanner sc = new Scanner(new File("kur.csv"));
            sc.useDelimiter(";");
            double array[] = new double[48];
            int i = 0 ;
            while(sc.hasNextLine())
            {
                localDate1 = (LocalDate.parse(sc.next()));
                if(localDate.equals(localDate1))
                {

                    array[i] = Double.parseDouble(sc.next()) ;
                    ++i;
                }
            }
        }
        catch (FileNotFoundException e)
        {
            System.out.println("kur");
        }
    }
} 
              