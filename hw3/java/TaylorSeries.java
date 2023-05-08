import java.util.Scanner;
import java.lang.Math;
import java.text.DecimalFormat;
import java.math.RoundingMode;
public class TaylorSeries {
    private static final DecimalFormat df = new DecimalFormat("0.00");

    public static double factorial(int n) {
        if (n == 0) {
            return 1;
        }

        return n * factorial(n - 1);
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // get n
        System.out.print("Input n: ");
        int n = input.nextInt();

        // get x
        System.out.print("Input x: ");
        double x = input.nextInt();

        // taylor series sum
        double sum = 0;

        // calculate taylor series
        for (int i = 0; i <= n; i++) {
            sum += (Math.pow(x, i) / factorial(i));
        }

        // print result
        df.setRoundingMode(RoundingMode.DOWN);
        System.out.print("e^x is: " + df.format(sum));
    }
}
