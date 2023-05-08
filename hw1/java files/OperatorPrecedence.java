import java.util.Scanner;

public class OperatorPrecedence {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // inputs
        System.out.print("Numbers (x, y, z): ");
        float x = input.nextFloat();
        float y = input.nextFloat();
        float z = input.nextFloat();

        // calculations
        float sum = x * x + y * y - Math.abs(z);
        double answer = Math.round(Math.cbrt(sum) * 100);

        // output
        System.out.print("Cube Root is " + answer/100);
    }
}
