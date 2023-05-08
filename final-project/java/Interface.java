import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.io.FileWriter;

public class Interface {
    String csvFile;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // prompt user for name of data file
        System.out.print("Please enter the name of the input file: ");
        String csvFile = scanner.nextLine();

        // read data from file and build database
        Catalogue database = new Catalogue();

        String line;
        String csvSplitBy = ",";

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            boolean isFirstLine = true; // flag to skip the first line
            while ((line = br.readLine()) != null) {
                if (isFirstLine) { // skip the first line
                    isFirstLine = false;
                    continue;
                }
                // use comma as separator
                String[] row = line.split(csvSplitBy);

                // initialize netflix title
                NetflixTitle title = null;

                if (row[6].contains("TV")) {
                    title = new TVShow(row[2], row[3], row[4], (row[5]), row[6], (row[7]), row[8]);
                } else {
                    title = new Movie(row[2], row[3], row[4], (row[5]), row[6], (row[7]), row[8]);
                }

                database.titles.add(title);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // display main menu
        while (true) {
            System.out.println("1. Add a title");
            System.out.println("2. Delete a title");
            System.out.println("3. Search for titles");
            System.out.println("4. Modify a title");
            System.out.println("Type Exit to end program");

            // get user choice
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    addTitle(scanner, database, csvFile);
                    break;
                case "2":
                    deleteTitle(scanner, database, csvFile);
                    break;
                case "3":
                    searchTitle(scanner, database);
                    break;
                case "4":
                    modifyTitle(scanner, database, csvFile);
                    break;
                case "Exit":
                    return;
                default:
                    System.out.println("Invalid choice, please try again.");
                    break;
            }
        }
    }

    private static void addTitle(Scanner scanner, Catalogue database, String csvFile) {
        // get title attributes
        System.out.println("Enter the type (Movie or TV Show): ");
        String type = scanner.nextLine();
        System.out.println("Enter the title: ");
        String title = scanner.nextLine();
        System.out.println("Enter the director: ");
        String director = scanner.nextLine();
        System.out.println("Enter the country: ");
        String country = scanner.nextLine();
        System.out.println("Enter the release year: ");
        String releaseYear = scanner.nextLine();
        System.out.println("Enter the rating: ");
        String rating = scanner.nextLine();
        System.out.println("Enter the duration (in minutes for movies, in number of seasons for TV shows): ");
        String duration = scanner.nextLine();
        System.out.println("Enter the genres (separated by ;): ");
        String genre = scanner.nextLine();

        NetflixTitle netflixTitle = null;

        if (type == "TV Show") {
            netflixTitle = new TVShow(title, director, country, releaseYear, rating, duration, genre);
            System.out.println(title + " has been added to the catalogue.");
        } else {
            netflixTitle = new Movie(title, director, country, releaseYear, rating, duration, genre);
            System.out.println(title + " has been added to the catalogue.");
        }

        database.titles.add(netflixTitle);

        writeTitlesToFile(scanner, database, csvFile);
    }

    private static void deleteTitle(Scanner scanner, Catalogue database, String csvFile) {
        System.out.println("The list of all the movies will show first, followed by the list of shows");
        // logic for showing 10 titles per page and using space bar to get more titles
        int pageSize = 10;
        int pageIndex = 0;
        boolean showMore = true;
        while (showMore) {
            List<NetflixTitle> titles = new ArrayList<>(database.titles);
            int startIndex = pageIndex * pageSize;
            int endIndex = Math.min(startIndex + pageSize, titles.size());
            for (int i = startIndex; i < endIndex; i++) {
                // get title name
                System.out.println((i + 1) + ". " + titles.get(i).getTitle());
            }
            // get user input
            if (endIndex < titles.size()) {
                System.out.println("Hit space bar to see more, or type the number of the title you would like to remove");
                String input = scanner.nextLine();
                // user wants to see more titles
                if (input.equals(" ")) {
                    pageIndex++;
                } else {
                    // user wants to delete a title (program ends after)
                    int index = Integer.parseInt(input) - 1;
                    database.titles.remove(index);
                    NetflixTitle title = titles.get(index);
                    System.out.println(title.getTitle() + " has been deleted.");
                    showMore = false;
                }
            } else {
                // there are no more titles to see, only option to delete
                System.out.println("Type the number of the title you would like to remove");
                int index = Integer.parseInt(scanner.nextLine()) - 1;
                NetflixTitle title = titles.get(index);
                database.titles.remove(index);
                System.out.println(title.getTitle() + " has been deleted.");
                showMore = false;
            }
        }

        writeTitlesToFile(scanner, database, csvFile);
    }

    private static void searchTitle(Scanner scanner, Catalogue database) {
        // prompt user for title type
        System.out.print("Enter title type (TV Show or Movie): ");
        String titleType = scanner.nextLine();

        // prompt user for search attribute
        System.out.print("Enter search attribute (director, country, releaseYear, rating, duration, genre): ");
        String attribute = scanner.nextLine();

        // Collect all the unique values for the selected attribute
        Set<String> uniqueValues = new HashSet<>();
        for (NetflixTitle title : database.titles) {
            switch (attribute) {
                case "rating":
                    uniqueValues.add(title.getRating());
                    break;
                case "director":
                    uniqueValues.add(title.getDirector());
                    break;
                case "genre":
                    uniqueValues.add(title.getGenre());
                    break;
                case "duration":
                    if (titleType == "TV Show") {
                        uniqueValues.add(title.getDuration());
                    } else { // movies
                        String strDuration = title.getDuration().replaceAll("\\D", "");
                        int duration = Integer.parseInt(strDuration);
                        int durationRange = (duration / 30) * 30;
                        uniqueValues.add(durationRange + " - " + (durationRange + 29) + " minutes");
                    }
                    break;
                case "country":
                    uniqueValues.add(title.getCountry());
                    break;
                case "releaseYear":
                    uniqueValues.add(title.getReleaseYear());
                    break;
                default:
                    System.out.println("Invalid search attribute.");
                    return;
            }
        }

        // Display all the unique values for the attribute selected
        System.out.println("Please select one of the unique attributes: ");
        for (String value : uniqueValues) {
            System.out.println(value);
        }

        // Prompt the user to input the specific value to search for
        System.out.println("Enter the specific value to search for: ");
        String searchValue = scanner.nextLine();

        // Search for titles that match the selected attribute and specific value
        List<NetflixTitle> matchingTitles = new ArrayList<>();
        for (NetflixTitle title : database.titles) {
            switch (attribute) {
                case "rating":
                    if (title.getRating().equals(searchValue)) {
                        matchingTitles.add(title);
                    }
                    break;
                case "director":
                    if (title.getDirector().equals(searchValue)) {
                        matchingTitles.add(title);
                    }
                    break;
                case "genre":
                    if (title.getGenre().contains(searchValue)) {
                        matchingTitles.add(title);
                    }
                    break;
                case "duration":
                    if (titleType == "TV Show") {
                        if (title.getDuration().equals(searchValue)) {
                            matchingTitles.add(title);
                        }
                    } else {
                        String strDuration = title.getDuration().replaceAll("\\D", "");
                        int duration = Integer.parseInt(strDuration);
                        int durationRange = (duration / 30) * 30;
                        if ((durationRange + " - " + (durationRange + 29) + " minutes").equals(searchValue)) {
                            matchingTitles.add(title);
                        }
                    }
                    break;
                case "country":
                    if (title.getCountry().equals(searchValue)) {
                        matchingTitles.add(title);
                    }
                    break;
                case "releaseYear":
                    if (title.getReleaseYear().equals(searchValue)) {
                        matchingTitles.add(title);
                    }
                    break;
            }
        }

        // Display all the titles with the specified value for the attribute selected
        System.out.println("Here are all the titles with the specified value for the attribute selected: ");
        for (NetflixTitle title : matchingTitles) {
            System.out.println(title.getTitle());
        }
    }

    private static void modifyTitle(Scanner scanner, Catalogue database, String csvFile) {
        System.out.println("Enter the new rating for the movie you chose:");
        // logic for showing 10 titles per page and using space bar to get more titles
        int pageSize = 10;
        int pageIndex = 0;
        boolean showMore = true;
        while (showMore) {
            List<NetflixTitle> titles = new ArrayList<>(database.titles);
            int startIndex = pageIndex * pageSize;
            int endIndex = Math.min(startIndex + pageSize, titles.size());
            for (int i = startIndex; i < endIndex; i++) {
                // get title name
                System.out.println((i + 1) + ". " + titles.get(i).getTitle());
            }
            // get user input
            if (endIndex < titles.size()) {
                System.out.println("Hit space bar to see more, or type the number of the title you would like to remove");
                String input = scanner.nextLine();
                // user wants to see more titles
                if (input.equals(" ")) {
                    pageIndex++;
                } else {
                    // user wants to modify a rating (program ends after)
                    System.out.println("Enter the new rating for the movie you chose:");
                    String newRating = scanner.nextLine();
                    int index = Integer.parseInt(input) - 1;
                    NetflixTitle title = titles.get(index);
                    title.setRating(newRating);
                    System.out.println("Rating for " + title.getTitle() + " is now " + newRating);
                    showMore = false;
                }
            } else {
                // there are no more titles to see, only option to modify rating
                System.out.println("Type the number of the title you would like to remove");
                int index = Integer.parseInt(scanner.nextLine()) - 1;
                System.out.println("Enter the new rating for the movie you chose:");
                String newRating = scanner.nextLine();
                NetflixTitle title = titles.get(index);
                title.setRating(newRating);
                System.out.println("Rating for " + title.getTitle() + " is now " + newRating);
                showMore = false;
            }
        }

        writeTitlesToFile(scanner, database, csvFile);
    }

    public static void writeTitlesToFile(Scanner scanner, Catalogue database, String csvFile) {
        try {
            FileWriter writer = new FileWriter(csvFile);
            // write header row
            writer.write("title,director,country,release_year,rating,duration,genre\n");
            // write each title
            for (NetflixTitle title : database.titles) {
                writer.write(title.getTitle() + ",");
                writer.write(title.getDirector() + ",");
                writer.write(title.getCountry() + ",");
                writer.write(title.getReleaseYear() + ",");
                writer.write(title.getRating() + ",");
                writer.write(title.getDuration() + ",");
                writer.write(title.getGenre() + "\n");
            }
            writer.close();
            System.out.println("Successfully wrote titles to file " + csvFile);
        } catch (IOException e) {
            System.out.println("Error writing titles to file " + csvFile);
            e.printStackTrace();
        }
    }
}