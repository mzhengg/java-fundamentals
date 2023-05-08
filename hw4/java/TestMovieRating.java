import java.util.Scanner;

public class TestMovieRating {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // user inputs movie name
        System.out.print("Enter the name of the movie: ");
        String name = scanner.nextLine();

        // user inputs mipaa rating
        System.out.print("Enter the MIPAA rating of the movie: ");
        String mipaaRating = scanner.nextLine();

        // initialize movie class with movie name and mipaa rating
        Movie movie = new Movie(name, mipaaRating);

        // user inputs rating
        System.out.print("Enter the rating of the movie (1 to 5, -1 to exit): ");
        int rating = scanner.nextInt();

        // keep prompting user for rating until -1
        while (rating != -1) {
            movie.addRating(rating);
            System.out.print("Enter the rating of the movie (1 to 5, -1 to exit): ");
            rating = scanner.nextInt();
        }

        // print movie name, mipaa rating, and average user rating
        System.out.println("Name of the movie: " + movie.getName());
        System.out.println("MIPAA Rating: " + movie.getMipaaRating());
        System.out.println("Average Rating: " + movie.getAverage());
    }
}