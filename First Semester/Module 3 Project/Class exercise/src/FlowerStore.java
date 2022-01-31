public class FlowerStore
{
    private String name;
    private double balance;
    Flower[][] flowers = new Flower[4][3];

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public double getBalance()
    {
        return balance;
    }

    public void setBalance(double balance)
    {
        this.balance = balance;
    }

    public void setFlowers(Flower flower, int x, int y)
    {
        try
        {
            flowers[x][y] = flower;
        }
        catch(ArrayIndexOutOfBoundsException e)
        {
            System.out.println("You Stoopid!");
        }
    }

    public FlowerStore(String name, double balance)
    {
        this.name = name;
        this.balance = balance;
    }

    public boolean sellFlowers(Customer customer, int x, int y)
    {
        if(customer.getBalance() >= flowers[x][y].getPrice())
        {
            customer.subtractAmount(flowers[x][y].getPrice());
            balance += flowers[x][y].getPrice();
            flowers[x][y] = null;
            return true;
        }
        return false;
    }
}
