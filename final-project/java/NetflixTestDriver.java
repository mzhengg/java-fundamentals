import java.util.Scanner;

public class NetflixTestDriver {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // prompt user to choose tv show or movie
        System.out.println("Would you like to build a TV show or a movie?");
        String titleType = scanner.nextLine();

        // get attributes of the title from user
        System.out.println("Please enter a Title: ");
        String title = scanner.nextLine();

        System.out.println("Please enter a Director: ");
        String director = scanner.nextLine();

        System.out.println("Please enter a Country: ");
        String country = scanner.nextLine();

        System.out.println("Please enter a Release year: ");
        String releaseYear = scanner.nextLine();

        System.out.println("Please enter a Rating (TV Parental Guidelines for shows and MPAA for movies): ");
        String rating = scanner.nextLine();

        System.out.println("Please enter a Duration (seasons for shows and minutes for movies): ");
        String duration = scanner.nextLine();

        System.out.println("Please enter a Genre: ");
        String genre = scanner.nextLine();

        // instantiate the tv show or movie based on the attributes collected
        NetflixTitle netflixTitle = null;

        if (titleType.equals("TV Show")) {
            System.out.println("Here is the created TV Show");
            netflixTitle = new TVShow(title, director, country, releaseYear, rating, duration, genre);
            // print contents of the title
            ((TVShow) netflixTitle).printAttributes();
        } else {
            System.out.println("Here is the created Movie");
            netflixTitle = new Movie(title, director, country, releaseYear, rating, duration, genre);
            // print contents of the title
            ((Movie) netflixTitle).printAttributes();
        }

        // ask user if they want to change any attribute
        System.out.println("Would you like to change any of the attributes? ");
        String changeChoice = scanner.nextLine();

        if (changeChoice.equals("Yes")) {
            // ask user which attribute they want to change
            System.out.println("Type the attribute you would like to change: ");
            String attributeChoice = scanner.nextLine();

            // print old value of attribute
            Object oldValue = null;
            switch (attributeChoice) {
                case "Title":
                    oldValue = netflixTitle.getTitle();
                    break;
                case "Director":
                    oldValue = netflixTitle.getDirector();
                    break;
                case "Country":
                    oldValue = netflixTitle.getCountry();
                    break;
                case "Release year":
                    oldValue = netflixTitle.getReleaseYear();
                    break;
                case "Rating":
                    oldValue = netflixTitle.getRating();
                    break;
                case "Duration":
                    oldValue = netflixTitle.getDuration();
                    break;
                case "Genre":
                    oldValue = netflixTitle.getGenre();
                    break;
            }

            System.out.println("Old value was: " + oldValue);

            // ask for new value and set attribute to new value
            System.out.println("What would you like to change " + attributeChoice + " to? ");
            String newValue = scanner.nextLine();

            switch (attributeChoice) {
                case "Title":
                    netflixTitle.setTitle(newValue);
                    break;
                case "Director":
                    netflixTitle.setDirector(newValue);
                    break;
                case "Country":
                    netflixTitle.setCountry(newValue);
                    break;
                case "Release year":
                    netflixTitle.setReleaseYear(newValue);
                    break;
                case "Rating":
                    netflixTitle.setRating(newValue);
                    break;
                case "Duration":
                    netflixTitle.setDuration(newValue);
                    break;
                case "Genre":
                    netflixTitle.setGenre(newValue);
                    break;
            }

            // print contents of the updated title
            if (titleType.equals("TV Show")) {
                System.out.println("Here is the new TV Show");
                ((TVShow) netflixTitle).printAttributes();
            } else {
                System.out.println("Here is the new Movie");
                ((Movie) netflixTitle).printAttributes();
            }
        }
    }
}