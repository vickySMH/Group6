abstract class Animal {
    private int x;
    private int y;

    public int getX() {
        return x;
    }

    public void setX(int x) {
        if (x < 0) //Checks if x is set in boundaries (Validation)
        {
            System.out.println("Animal's x cannot be less than 0 changing x to 0!");
            x = 0;
        }
        if (x > 10) //Checks if x is set in boundaries (Validation)
        {
            System.out.println("Since our grid is only 10x10 changing animal's x to 10!");
            x = 10;
        }
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        if (y < 0) //Checks if y is set in boundaries (Validation)
        {
            System.out.println("Rabbit's y cannot be less than 0 changing y to 0!");
            y = 0;
        }
        if (y > 10) //Checks if y is set in boundaries (Validation)
        {
            System.out.println("Since our grid is only 10x10 changing rabbit's y to 10!");
            y = 10;
        }
        this.y = y;
    }
}
