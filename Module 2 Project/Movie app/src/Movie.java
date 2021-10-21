import java.util.ArrayList;
import java.util.Scanner;

enum Genre {
    ACTION, COMEDY, DRAMA, FANTASY, HORROR, MYSTERY, ROMANCE, THRILLER
}

public class Movie {
    private ArrayList<Actor> cast = new ArrayList<Actor>();
    private String title;
    private Genre genre;


    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public void setGenre(Genre genre) {
        this.genre = genre;
    }
    public Genre getGenre() {
        return genre;
    }

    public void setActor(Actor actor) {
       cast.add(actor);
    }
}

        /*public static void main(String[] args)
        {
            System.out.println("Welcome to the Movie List Application");
            System.out.println();
            System.out.println("There are 100 movie in the list");
            String choice = "y";
            Scanner scanner = new Scanner(System.in);

            ArrayList<String> Horror = new ArrayList<>();
            Horror.add("");
            Horror.add("");
            Horror.add("");
            Horror.add("");
            Horror.add("");


            ArrayList<String> Comedy = new ArrayList<>();
            Comedy.add("");
            Comedy.add("");
            Comedy.add("");
            Comedy.add("");
            Comedy.add("");


            ArrayList<String> Drama = new ArrayList<>();
            Drama.add("");
            Drama.add("");
            Drama.add("");
            Drama.add("");
            Drama.add("");


            ArrayList<String> Animated = new ArrayList<>();
            Animated.add("");
            Animated.add("");
            Animated.add("");
            Animated.add("");
            Animated.add("");


            ArrayList<String> Scifi = new ArrayList<>();
            Scifi.add("");
            Scifi.add("");
            Scifi.add("");
            Scifi.add("");
            Scifi.add("");

            while(choice.equalsIgnoreCase("y"))
            {
                System.out.print("Which genre of movie are you interested in?");

                String Movie = scanner.nextLine();
                //The switch statement is a multi-way branch statement. (Dispatch execution)
                switch (Movie) {
                    case "Horror":
                        System.out.println(Horror);
                        break;
                    case "Comedy":
                        System.out.println(Comedy);
                        break;
                    case "Drama":
                        System.out.println(Drama);
                        break;
                    case "Animated":
                        System.out.println(Animated);
                        break;
                    case "Scifi":
                        System.out.println(Scifi);
                        break;
                }

                System.out.print("Continue? y/n): ");
                choice = scanner.next();
            }
        }
        */