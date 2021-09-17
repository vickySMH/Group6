public class Rabbit {
    private int x;
    private int y;
    private boolean xDirection = true; //Keeps the direction of the rabbit, true is right false is left.
    private boolean yDirection = true; //Keeps the direction of the rabbit, true is upwards and false is downwards.
    private boolean reachCorner = false; //Checks if rabbit has reached corner.

    //Constructors
    public Rabbit() {
        x = 0;
        y = 0;
    }

    public Rabbit(int x) {
        setX(x);
        y = 0;
    }

    public Rabbit(int x, int y) {
        setX(x);
        setY(y);
    }

    //Getters and Setters


    public boolean hasReachedCorner() {
        return reachCorner;
    }

    public void setReachCorner(boolean reachCorner) {
        this.reachCorner = reachCorner;
    }

    public int getX() {
        return x;
    }

    public void setX(int xChange) {
        if (xChange < 0) //Checks if x is set in boundaries (Validation)
        {
            System.out.println("Rabbit's x cannot be less than 0 changing x to 0!");
            xChange = 0;
        }
        if (xChange > 10) //Checks if x is set in boundaries (Validation)
        {
            System.out.println("Since our grid is only 10x10 changing rabbit's x to 10!");
            xChange = 10;
        }
        x = xChange;
    }

    public int getY() {
        return y;
    }

    public void setY(int yChange) {
        if (yChange < 0) //Checks if y is set in boundaries (Validation)
        {
            System.out.println("Rabbit's y cannot be less than 0 changing y to 0!");
            yChange = 0;
        }
        if (yChange > 10) //Checks if y is set in boundaries (Validation)
        {
            System.out.println("Since our grid is only 10x10 changing rabbit's y to 10!");
            yChange = 10;
        }
        y = yChange;
    }

    public void rabbitMove()
    {
        if (xDirection == true && x < 10)
        {
            ++x;
        }
        if (xDirection == false && x > 0)
        {
            --x;
        }
        if (yDirection == true && y < 10)
        {
            ++y;
        }
        if (yDirection == false && y > 0)
        {
            --y;
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

