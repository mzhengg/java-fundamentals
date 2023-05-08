import java.util.Scanner;
import java.text.DecimalFormat;
import java.math.RoundingMode;
public class AreaFromCircumference {
    private static final DecimalFormat df = new DecimalFormat("0.00");
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // get circumference as input
        System.out.print("Circumference: ");
        double circumference = input.nextDouble();

        // calculate radius
        // circumference = 2*pi*radius
        // radius = circumference/(2*pi)
        double radius = circumference / (2 * (22/7));

        // calculate area
        // area = pi*radius^2
        double area = (22/7) * radius * radius;

        // print area as output
        df.setRoundingMode(RoundingMode.DOWN);
        System.out.print("Area of circle is: " + df.format(area));
    }
}

// Can π be encoded as “static final” in the code? Why or why not? Justify your answer.
// Static means that the value is the same for every instance of the class. Final means that once the variable has been assigned a value it can't be changed.
// So, static final is how one creates a constant value in Java
// Thus, π can be encoded as static final since it is always 3.14...