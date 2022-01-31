abstract public class Can
{
    static void typeOfPant(char type)
    {
        float typeBPrice = (float) 1.5;
        switch (type)
        {
            case 'A':
            {
                RecyclingMachine.itterate(type);
                System.out.println("Successfully deposited a type 'A' pant");
                RecyclingMachine.setRefunded(RecyclingMachine.getRefunded() + 1);
                break;
            }
            case 'B':
            {
                RecyclingMachine.itterate(type);
                System.out.println("Successfully deposited a type 'B' pant");
                RecyclingMachine.setRefunded(RecyclingMachine.getRefunded() + typeBPrice);
                break;
            }
            case 'C':
            {
                RecyclingMachine.itterate(type);
                System.out.println("Successfully deposited a type 'C' pant");
                RecyclingMachine.setRefunded(RecyclingMachine.getRefunded() + 3);
                break;
            }
            case 'O':
            {
                break;
            }
            default:
            {
                System.out.println("Check if your can has a pant, if it does, please, try again!");
                break;
            }
        }
    }
}
