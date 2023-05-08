import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class TestDocumentaries {
    public static void main(String[] args) {
        // get file name
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the file name: ");
        String fileName = scanner.nextLine();
        scanner.close();

        // read file
        File file = new File(fileName);
        if (!file.exists()) {
            System.out.println("File not found!");
            return;
        }

        // keep track of the number of documentaries and series
        int numDocumentaries = 0;
        int numSeries = 0;

        // hash maps to keep track of the number of mipaa and tv ratings
        Map<String, Integer> mipaaCount = new HashMap<>();
        Map<String, Integer> tvRatingCount = new HashMap<>();

        // keep track of the DocumentarySeries instances that have the max season / episodes
        DocumentarySeries maxSeasonSeries = null;
        DocumentarySeries maxEpisodesSeries = null;

        // open file
        try (Scanner fileScanner = new Scanner(file)) {
            // iterate through each line
            while (fileScanner.hasNextLine()) {
                // split by commas
                String line = fileScanner.nextLine();
                String[] elements = line.split(",");

                // if the number of elements in the file is < 3; then, invalid format
                if (elements.length < 3) {
                    // skip this line and continue to the next line
                    continue;
                }

                // get the title, mpaaRating, and tvRating
                String title = elements[0].trim();
                String mipaaRating = elements[1].trim();
                String tvRating = elements[2].trim();

                // this line is a documentary series
                if (elements.length == 5) {
                    // get the number of seasons and episodes
                    int seasons = Integer.parseInt(elements[3].trim());
                    int episodes = Integer.parseInt(elements[4].trim());

                    // make a DocumentarySeries instance for this line
                    DocumentarySeries docSeries = new DocumentarySeries(title, mipaaRating, tvRating, seasons, episodes);

                    // increment the number of documentary series
                    numSeries += 1;

                    // update maxSeasonSeries if it is empty or the current series has the most number of seasons
                    if (maxSeasonSeries == null || docSeries.getNumSeasons() > maxSeasonSeries.getNumSeasons()) {
                        maxSeasonSeries = docSeries;
                    }

                    // update maxEpisodeSeries if it is empty or the current series has the most number of episodes
                    if (maxEpisodesSeries == null || docSeries.getNumEpisodes() > maxEpisodesSeries.getNumEpisodes()) {
                        maxEpisodesSeries = docSeries;
                    }

                // otherwise; this line is just a documentary
                } else {
                    numDocumentaries += 1;
                }

                // update the mipaaCount and tvRatingCount hash maps
                mipaaCount.put(mipaaRating, mipaaCount.getOrDefault(mipaaRating, 0) + 1);
                tvRatingCount.put(tvRating, tvRatingCount.getOrDefault(tvRating, 0) + 1);
            }

        // file could not be opened; return an error
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        // aggregate report summarizing the contents of the data file
        System.out.println("Number of Documentaries: " + numDocumentaries);
        System.out.println("Number of Documentary Series: " + numSeries);

        // prints the number of MIPAA ratings
        for (Map.Entry<String, Integer> entry : mipaaCount.entrySet()) {
            System.out.println("Number of " + entry.getKey() + " Documentaries: " + entry.getValue());
        }
        // prints the number of TV ratings
        for (Map.Entry<String, Integer> entry : tvRatingCount.entrySet()) {
            System.out.println("Number of " + entry.getKey() + " Documentaries: " + entry.getValue());
        }

        System.out.println(maxSeasonSeries.getName() + " is the documentary series with highest number of seasons - " + maxSeasonSeries.getNumSeasons());
        System.out.println(maxEpisodesSeries.getName() + " is the documentary series with highest number of episodes - " + maxEpisodesSeries.getNumEpisodes());
    }
}