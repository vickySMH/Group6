public class Main
{
    public static void main(String[] args)
    {
        Snake snake = new Snake(10,10);
        Rabbit rabbit = new Rabbit( 5, 5);
        int checkTurn = 0;
        System.out.println("I am the rabbit I am now standing on " + rabbit.getX() + " " + rabbit.getY());
        System.out.println("I am the snake I am now standing on " + snake.getX() + " " + snake.getY());
        //Loop goes until snake has reached rabbit
        while (snake.getX() != rabbit.getX() ||  snake.getY() != rabbit.getY())
        {
            //Checks whether the snake is one square away from the rabbit
            if((snake.getX() == rabbit.getX() && snake.getY() == rabbit.getY() + 1)
                    || (snake.getX() == rabbit.getX() && snake.getY() == rabbit.getY() - 1)
                    || (snake.getX() == rabbit.getX() + 1 && snake.getY() == rabbit.getY())
                    || (snake.getX() == rabbit.getX() - 1 && snake.getY() == rabbit.getY())
                    || (snake.getX() == rabbit.getX() + 1 && snake.getY() == rabbit.getY() + 1)
                    || (snake.getX() == rabbit.getX() + 1 && snake.getY() == rabbit.getY() - 1)
                    || (snake.getX() == rabbit.getX() - 1 && snake.getY() == rabbit.getY() + 1)
                    || (snake.getX() == rabbit.getX() - 1 && snake.getY() == rabbit.getY() - 1))
            {
                System.out.println("Rabbit: Oh no, please do not eat me!");
            }
            else
            {
                if((rabbit.getX() != 0 && rabbit.getX() != 10) && (rabbit.getY() != 0 && rabbit.getY() != 10)
                        && rabbit.hasReachedCorner() == false)
                {
                    if(rabbit.getX() >= snake.getX())
                    {
                        rabbit.setXDirection(true);
                    }
                    else
                    {
                        rabbit.setXDirection(false);
                    }
                    if(rabbit.getY() >= snake.getY())
                    {
                        rabbit.setYDirection(true);
                    }
                    else
                    {
                        rabbit.setYDirection(false);
                    }
                }
                if(rabbit.getX() == 0 && rabbit.getY() == 0)
                {
                        rabbit.setXDirection(true);
                        rabbit.setYDirection(true);
                    if(snake.getX() >= snake.getY())
                    {
                        rabbit.setYDirection(false);
                    }
                    else
                    {
                        rabbit.setXDirection(false);
                    }
                    rabbit.setReachCorner(true);
                }
                if(rabbit.getX() == 0 && rabbit.getY() == 10)
                {
                        rabbit.setXDirection(true);
                        rabbit.setYDirection(false);
                        rabbit.setReachCorner(true);
                }
                if(rabbit.getX() == 10 && rabbit.getY() == 0)
                {
                        rabbit.setXDirection(false);
                        rabbit.setYDirection(true);
                        rabbit.setReachCorner(true);
                }
                if(rabbit.getX() == 10 && rabbit.getY() == 10)
                {
                        rabbit.setXDirection(false);
                        rabbit.setYDirection(false);
                        if(snake.getX() >= snake.getY())
                        {
                            rabbit.setYDirection(true);
                        }
                        else
                        {
                            rabbit.setXDirection(true);
                        }
                        rabbit.setReachCorner(true);
                }
                rabbit.rabbitMove();

                System.out.println("Rabbit: I am the rabbit I am now standing on " + rabbit.getX() + " " + rabbit.getY());
                //Checks if rabbit has moved to its death
                if((snake.getX() == rabbit.getX() && snake.getY() == rabbit.getY() + 1)
                        || (snake.getX() == rabbit.getX() && snake.getY() == rabbit.getY() - 1)
                        || (snake.getX() == rabbit.getX() + 1 && snake.getY() == rabbit.getY())
                        || (snake.getX() == rabbit.getX() - 1 && snake.getY() == rabbit.getY())
                        || (snake.getX() == rabbit.getX() + 1 && snake.getY() == rabbit.getY() + 1)
                        || (snake.getX() == rabbit.getX() + 1 && snake.getY() == rabbit.getY() - 1)
                        || (snake.getX() == rabbit.getX() - 1 && snake.getY() == rabbit.getY() + 1)
                        || (snake.getX() == rabbit.getX() - 1 && snake.getY() == rabbit.getY() - 1))
                {
                    System.out.println("Rabbit: Oh no, please do not eat me!");
                }
            }
            if (snake.getX() < rabbit.getX()) //Checks if the snake is behind the rabbit
            {
                snake.setX(snake.getX()+1); //If it is snake moves forward
            }
            if (snake.getY() < rabbit.getY()) //Checks if the snake is beneath the rabbit
            {
                snake.setY(snake.getY()+1); //If it is snake moves up
            }
            if (snake.getX() > rabbit.getX()) //Checks if the snake is in front of the rabbit
            {
                snake.setX(snake.getX()-1); //If it is snake moves backward
            }
            if (snake.getY() > rabbit.getY()) //Checks if the snake is above the rabbit
            {
                snake.setY(snake.getY()-1); //If it is snake moves down
            }
            System.out.println("Snake: I am the snake I am now standing on " + snake.getX() + " " + snake.getY());
        }
        //After exiting the loop snake eats the rabbit
        System.out.println("Snake: Haha, I am eating you, rabbit!");
    }
}


