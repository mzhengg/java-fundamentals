import java.util.Scanner;

public class WhatsInAName {
    public static void main(String[] args) {
        Scanner stringScanner = new Scanner(System.in);

        // input string
        System.out.print("Please enter your first name and last name, separated by a space\n");
        String name = stringScanner.nextLine();

        // split name by space
        String splitName[] = name.split("\\s+");

        // print the output
        System.out.print("Your first name is " + splitName[0] + ", which has " + splitName[0].length() + " characters\n");
        System.out.print("Your last name is " + splitName[1] + ", which has " + splitName[1].length() + " characters\n");
        System.out.print("Your initials are " + splitName[0].charAt(0) + splitName[1].charAt(0));
    }
}
