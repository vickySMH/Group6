public class Snake extends Animal
{

    //Constructors
    public Snake()
    {

        setX(0);
        setY(0);
    }

    public Snake(int x)
    {
        setX(x);
        setY(0);
    }

    public Snake(int x, int y)
    {
        setX(x);
        setY(y);
    }

    //Methods

    public void tellCoordinates() //Say coordinates
    {
        System.out.println("I am the snake I am now standing on " + getX() + " " + getY());
    }

    public void eatRabbit() //Message for eating the rabbit
    {
        System.out.println("Snake: Haha, I am eating you, rabbit!");
    }
}