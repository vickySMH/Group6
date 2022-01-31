public class Run
{
    public static void main(String[] args)
    {
        Toy toy = new Toy("Barbie", 350);
        Playroom playroom = new Playroom();
        playroom.addToy(toy);
        playroom.addToy(new Toy("Car", 250));
        playroom.addToy(new Toy ("Robot", 1500));
        playroom.averageWeight();
    }
}
