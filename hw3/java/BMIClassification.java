import java.util.Scanner;

public class BMIClassification {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // get weight in pounds
        System.out.print("Enter your weight in pounds: ");
        double weightPounds = input.nextDouble();

        // get height in inches
        System.out.print("Enter your height in inches: ");
        double heightInches = input.nextDouble();

        // convert weight to kilos
        double weightKilo = weightPounds * 0.4536;

        // convert height to meters
        double heightMeters = heightInches * 0.0254;

        // calculate bmi
        double bmi = weightKilo / (heightMeters * heightMeters);

        // print bmi
        System.out.print("Your BMI is " + bmi + "\n");

        // risk classification
        if (bmi < 18.5) {
            System.out.print("Your risk category is Underweight.\n");
        }
        else if (bmi >= 18.5 && bmi < 25) {
            System.out.print("Your risk category is Normal weight.\n");
        }
        else if (bmi >= 25 && bmi < 30) {
            System.out.print("Your risk category is Overweight.\n");
        }
        else {
            System.out.print("Your risk category is Obese.\n");
        }
    }
}
