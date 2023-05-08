import java.util.Scanner;

public class BinarytoDecimal {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // take binary as input integer
        System.out.print("Please enter 4 digit binary: ");
        int binary = input.nextInt();

        // convert binary to string
        String binaryString = Integer.toString(binary);

        char sb3 = binaryString.charAt(0);
        char sb2 = binaryString.charAt(1);
        char sb1 = binaryString.charAt(2);
        char sb0 = binaryString.charAt(3);

        // convert binary string to integer
        int b3 = Character.getNumericValue(sb3);
        int b2 = Character.getNumericValue(sb2);
        int b1 = Character.getNumericValue(sb1);
        int b0 = Character.getNumericValue(sb0);

        // calculate decimal
        int decimal;

        decimal = 8*b3 + 4*b2 + 2*b1 + b0;

        System.out.println("The decimal value is " + decimal);
    }
}
