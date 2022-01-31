import java.util.ArrayList;

public class Playroom
{
    ArrayList<Toy> toys = new ArrayList<>();

    public void addToy(Toy toy)
    {
        if(toy.getWeight() < 1000)
        {
            toys.add(toy);
        }
        else
        {
            System.out.println("Toy is too heavy");
        }
    }

    public void averageWeight()
    {
        double averageWeight = 0;
        for (Toy toy: toys)
        {
            averageWeight += toy.getWeight();
        }

        averageWeight/=toys.size();
        System.out.println("Average weight of toys is " + averageWeight);

    }

}
