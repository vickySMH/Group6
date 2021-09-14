public class Snake
{
    private int x;
    private int y;

    //Constructors
    public Snake()
    {

        x = 1;
        y = 1;
    }

    public Snake(int x)
    {
        setX(x);
        y = 1;
    }

    public Snake(int x, int y)
    {
        setX(x);
        setY(y);
    }
    //Getters and Setters
    public int getX()
    {
        return x;
    }

    public void setX(int xChange)
    {

        if (xChange < 0) //Checks if x is set in boundaries (Validation)
        {
            System.out.println("Snake's x cannot be less than 0 changing x to 0!");
            xChange = 0;
        }
        if (xChange > 10) //Checks if x is set in boundaries (Validation)
        {
            System.out.println("Since our grid is only 10x10 changing snake's x to 10!");
            xChange = 10;
        }
        x = xChange;
    }

    public int getY()
    {
        return y;
    }

    public void setY(int yChange)
    {
        if (yChange < 0) //Checks if y is set in boundaries (Validation)
        {
            System.out.println("Snake's y cannot be less than 0 changing y to 0!");
            yChange = 0;
        }
        if (yChange > 10) //Checks if y is set in boundaries (Validation)
        {
            System.out.println("Since our grid is only 10x10 changing snake's y to 10!");
            yChange = 10;
        }
        y = yChange;
    }
}

