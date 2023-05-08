import java.util.Scanner;
import java.text.DecimalFormat;
import java.math.RoundingMode;

//D.1: The equation written by the physics student doesn't follow orders of operations
// (G*m1*m2/r)*r, which is what the student is doing, is not equivalent to G*m1*m2/(r^2), which is the correct way
public class Force {
    private static final DecimalFormat df = new DecimalFormat("0.00");
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // inputs
        System.out.print("Values (m1, m2, r): ");
        double m1 = input.nextFloat();
        double m2 = input.nextFloat();
        double r = input.nextFloat();
        double G = 6.674 * Math.pow(10, -11);

        // calculations
        double force = G*m1*m2/Math.pow(r, 2);

        // output
        df.setRoundingMode(RoundingMode.DOWN);
        System.out.print("Force is " + df.format(force));
    }
}
