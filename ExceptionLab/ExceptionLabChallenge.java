import java.util.*;
public class ExceptionLabChallenge {
    public static void main(String[] args){
        //set scanner and variable
        Scanner in = new Scanner(System.in);
        double x;
        //tries to get in a number from the user to take the square root
        try{
            System.out.println("Input a number to find the square root:");
            x = in.nextDouble();
            //if the user enters a negative number, The program will give an arithmetic error because Math.sqrt(negative number) returns Nan - not an error
            if (x<0){
                x = 10/0;
            }
            System.out.println((Math.sqrt(x)));
        }
            //if the user enters a negative
        catch(ArithmeticException e){
            System.out.println("You cannot take the square root of a negative number. Please enter a new number: ");
            x = in.nextDouble();
            System.out.println(Math.sqrt(x));
        }
            //if the user enters something that isnt a number. 
        catch(InputMismatchException e){
            System.out.println("Error you didn't enter a number, please try inputting a NUMBER again");
            x = in.nextDouble();
            System.out.println(Math.sqrt(x));
        }
    }

}
