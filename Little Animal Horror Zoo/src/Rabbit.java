public class Rabbit extends Animal {
    private boolean xDirection = true; //Keeps the direction of the rabbit, true is right false is left.
    private boolean yDirection = true; //Keeps the direction of the rabbit, true is upwards and false is downwards.
    private boolean reachCorner = false; //Checks if rabbit has reached corner.

    //Constructors
    public Rabbit() {
        setX(0);
        setY(0);
    }

    public Rabbit(int x) {
        setX(x);
        setY(0);
    }

    public Rabbit(int x, int y) {
        setX(x);
        setY(y);
    }

    //Methods

    public void tellCoordinates() //Say coordinates
    {
        System.out.println("I am the rabbit I am now standing on " + getX() + " " + getY());
    }

    public void cry() //Rabbit's cry for help
    {
        System.out.println("Rabbit: Oh no, please do not eat me!");
    }

    //Getters and Setters

    public boolean hasReachedCorner() {
        return reachCorner;
    }

    public void setReachCorner(boolean reachCorner) {
        this.reachCorner = reachCorner;
    }

    public void rabbitMove()
    {
        if (xDirection == true && getX() < 10)
        {
            setX(getX()+1);
        }
        if (xDirection == false && getX() > 0)
        {
            setX(getX()-1);
        }
        if (yDirection == true && getY() < 10)
        {
            setY(getY()+1);
        }
        if (yDirection == false && getY() > 0)
        {
            setY(getY()-1);
        }
    }

    public void setXDirection(boolean xDirection)
    {
        this.xDirection = xDirection;
    }

    public boolean getXDirection()
    {
        return xDirection;
    }
    public void setYDirection (boolean yDirection)
    {
        this.yDirection = yDirection;
    }

    public boolean getYDirection() {
        return yDirection;
    }
}

