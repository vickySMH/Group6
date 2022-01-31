public class Toy
{
    private String name;
    private double weight;

    public double getWeight()
    {
        return weight;
    }

    public void setWeight(double weight)
    {
        this.weight = weight;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public Toy(String name, double weight)
    {
        setName(name);
        setWeight(weight);
    }

}
