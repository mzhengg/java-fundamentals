import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class VendingChange {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // get item cost
        System.out.print("Cost: ");
        int cost = input.nextInt();
        double remaining = 100;
        if (cost == 100){
            remaining = 0;
            System.out.println("You bought an item for 1 and gave me a dollar, so you have no change!");
        }
        else {
            remaining -= cost;
        }

        // this program assumes the following change denominations:
        // half-dollar, quarter, dime, nickel, penny
        double change[] = {25, 10, 5};
        int n_of_change = 3;

        // keep track of change
        List<Double> output = new ArrayList<>();

        int i = 0;
        while (remaining > 0) {
            if (remaining - change[i] >= 0) {
                remaining -= change[i];
                output.add(change[i]);
            }
            else {
                i++;
            }
        }

        // print results
        System.out.print("You bought an item for " + cost);
        System.out.print(" and gave me a dollar,\n");
        System.out.println("so your change is");

        int quarters = 0;
        int dimes = 0;
        int nickels = 0;

        int k;
        for (k=0; k<output.size(); k++) {
            if (output.get(k) == 25) {
                quarters += 1;
            }
            else if (output.get(k) == 10) {
                dimes += 1;
            }
            else {
                nickels += 1;
            }
        }

        if (quarters != 1) {
            System.out.print(quarters + " quarters,\n");
        }
        else {
            System.out.print(quarters + " quarter,\n");
        }

        if (dimes != 1) {
            System.out.print(dimes + " dimes, and\n");
        }
        else {
            System.out.print(dimes + " dime, and\n");
        }

        if (nickels != 1) {
            System.out.print(nickels + " nickels.");
        }
        else {
            System.out.print(nickels + " nickel.");
        }
    }
}
