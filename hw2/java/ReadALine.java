import java.util.Scanner;

public class ReadALine {
    public static void main(String[] args) {
        Scanner stringScanner = new Scanner(System.in);

        // input string
        System.out.print("Enter a line of text. No punctuation please.\n");
        String text = stringScanner.nextLine();

        System.out.print("I have rephrased that line to read:\n");

        // split string by spaces
        String splitString[] = text.split("\\s+");

        // print second word as new first word with first letter capitalized
        System.out.print(splitString[1].substring(0, 1).toUpperCase());
        System.out.print(splitString[1].substring(1) + " ");

        // print all words after the first and second word from original input
        for (int i = 2; i < splitString.length; i++) {
            System.out.print(splitString[i] + " ");
        }

        // print first word as new last word with all lowercase
        System.out.print(splitString[0].toLowerCase());
    }
}
