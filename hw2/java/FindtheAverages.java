import java.util.Scanner;
import java.util.List;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.IOException;
import java.text.DecimalFormat;
import java.math.RoundingMode;

public class FindtheAverages {
    private static final DecimalFormat df = new DecimalFormat("0.00");

    public static void main(String[] args) {
        // get file name from user
        Scanner fileNameScanner = new Scanner(System.in);
        System.out.print("Enter the name of the input file (path to file):\n");
        String fileName = fileNameScanner.nextLine();

        // read lines from the input file
        try {
            List<String> allLines = Files.readAllLines(Paths.get(fileName));

            for (String line : allLines) {
                // split the line based on ", " and store the values in an array
                String splitLines[] = line.split(", ");

                // calculate the average
                float sum = 0;
                for (int i = 1; i < splitLines.length; i++) {
                    sum += Integer.parseInt(splitLines[i]);
                }
                float average = sum / (splitLines.length - 1);

                // print the output
                df.setRoundingMode(RoundingMode.UP);
                System.out.println("The average score for " + splitLines[0] + " is " + df.format(average));
            }
        }

        // if there is an error, return the error
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
