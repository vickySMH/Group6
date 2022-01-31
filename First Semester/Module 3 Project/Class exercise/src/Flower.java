public class Flower
{
    private String name;
    private double price;

    public double getPrice()
    {
        return price;
    }

    public void setPrice(double price)
    {
        this.price = price;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public Flower(String name, double price)
    {
        setName(name);
        setPrice(price);
    }
}
