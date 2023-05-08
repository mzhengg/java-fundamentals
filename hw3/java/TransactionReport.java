import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.text.DecimalFormat;

public class TransactionReport {
    private static final DecimalFormat df = new DecimalFormat("0.00");

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // get file name
        System.out.print("Please enter the transaction filename: ");
        String fileName = input.nextLine();
        File file = new File(fileName);

        // read the file
        try {
            Scanner fileInput = new Scanner(file);

            // Skip the header line
            fileInput.nextLine();

            double saleTotal = 0.0;

            while (fileInput.hasNextLine()) {
                String line = fileInput.nextLine();
                Scanner lineScanner = new Scanner(line);
                lineScanner.useDelimiter(",");

                // get data from line
                String item = lineScanner.next();
                int quantity = lineScanner.nextInt();
                double price = lineScanner.nextDouble();
                String itemName = lineScanner.next();
                double saleAmount = quantity * price;

                // add sale amount to total
                saleTotal += saleAmount;

                // print report
                System.out.println("Sold " + quantity + " of " + itemName + " (SKU: " + item + ") at $" + df.format(price) + " each. Sale is $" + df.format(saleAmount));
                lineScanner.close();
            }

            // print total sales
            System.out.println("Total sales: $" + df.format(saleTotal));
            fileInput.close();

        // return an error if file is not found
        } catch (FileNotFoundException e) {
            System.out.println("Error: File not found.");
        }

        input.close();
    }
}