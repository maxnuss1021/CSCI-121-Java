import java.util.*;
public class ExceptionLabChallenge {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        double x;
        try{
            System.out.println("Input a number to find the square root:");
            x = in.nextDouble();
            if (x<0){
                x = 10/0;
            }
            System.out.println((Math.sqrt(x)));
        }
        catch(ArithmeticException e){
            System.out.println("You cannot take the square root of a negative number. Please enter a new number: ");
            x = in.nextDouble();
            System.out.println(Math.sqrt(x));
        }
        catch(Exception e){
            System.out.println("Error, please try inputting a number again");
            x = in.nextDouble();
            System.out.println(Math.sqrt(x));
        }
    }

}
