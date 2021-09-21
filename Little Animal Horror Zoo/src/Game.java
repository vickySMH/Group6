public class Game {
    public void runGame()
    {
        Snake snake = new Snake(5,2);
        Rabbit rabbit = new Rabbit(8,7);
        rabbit.tellCoordinates();
        snake.tellCoordinates();
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
                rabbit.cry();
            }
            else
            {
                if(rabbit.getX() == 0 || rabbit.getX() == 10 || rabbit.getY() == 0 || rabbit.getY() == 10)
                {
                    //Checks if rabbit has reached corner
                    rabbit.setReachCorner(true);
                }
                if((rabbit.getX() != 0 && rabbit.getX() != 10) && (rabbit.getY() != 0 && rabbit.getY() != 10)
                        && rabbit.hasReachedCorner() == false) //Checks for the directions in which the rabbit should be moving
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
                }
                if(rabbit.getX() == 0 && rabbit.getY() == 10)
                {
                    rabbit.setXDirection(true);
                    rabbit.setYDirection(false);
                    if(snake.getX() <= rabbit.getX())
                    {
                        rabbit.setXDirection(true);
                        rabbit.setYDirection(true);
                    }
                }
                if(rabbit.getX() == 10 && rabbit.getY() == 0)
                {
                    rabbit.setXDirection(false);
                    rabbit.setYDirection(true);
                    if(snake.getX() >= rabbit.getX())
                    {
                        rabbit.setXDirection(false);
                        rabbit.setYDirection(false);
                    }
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
                }
                rabbit.rabbitMove();
                rabbit.tellCoordinates();
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
                    rabbit.cry();
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
            snake.tellCoordinates();
        }
        //After exiting the loop snake eats the rabbit
        snake.eatRabbit();
    }
}

