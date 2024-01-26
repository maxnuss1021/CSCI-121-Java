//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.

import java.util.*;
public class Main { // I adapted the program to be more practical for cash reg
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("What is your change?");
        String myamount = in.next(); //takes in a double and multiplies it by 100 to get an integer
        myamount = myamount.replace("$", " ");
        int amount = (int) (Double.parseDouble(myamount) * 100);
        System.out.println("Would you like dollar bills if necessary? (Y/N)"); // Creative aspect. Allows user to select if he wants full bills or just coins.
        String answer = in.next();
        if (answer.equals("Y")) { // If the user wants to get bills along with coins this if statement will be true. It will calculate each bill amount and return them.
            int hundred = amount / 10000;
            amount -= hundred * 10000;
            int fifty = amount / 5000;
            amount -= fifty * 5000;
            int twent = amount / 2000;
            amount -= twent * 2000;
            int ten = amount / 1000;
            amount -= ten * 1000;
            int five = amount / 500;
            amount -= five * 500;
            int single = amount / 100;
            amount -= single * 100;
            System.out.println("For Dollars, you have " + hundred + " Hundreds, " + fifty + " Fifties, " + twent + " Twenties, " + ten + " Tens, " + single + " Singles.");
            //if the if statement is true all of these statements will run after the program prints the bill amounts. If not then it will just skip to these.
            //These statements calculate the quantity of coins returned.
            int quarter = amount / 25;
            amount -= quarter * 25;
            int dime = amount / 10;
            amount -= dime * 10;
            int nickle = amount / 5;
            amount -= nickle * 5;
            int pennies = amount;
            System.out.println("For Coins, you have " + quarter + " Quarters, " + dime + " Dimes, " + nickle + " Nickles, " + pennies + " Pennies");
        }
    }
}
