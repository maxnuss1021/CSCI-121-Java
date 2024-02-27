import java.util.*;
public class BadSubscriptCaught {
    //set variables/array
    static int x;
    static String [] ar = {"Joe", "Matt", "Morgan", "Eddie", "Sarah", "Mike", "Emma", "Sadie", "Mark", "James"};
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        try{
            //tries to get a value from the user and will return the corresponding name.
            System.out.println("Input an integer to get the corresponding name:");
             x = in.nextInt();
            System.out.println(ar[x-1]);
        }
            //if it is out of bounds, it will as the user to reinput the number between 1 and 10 to keep it in bounds
        catch(IndexOutOfBoundsException e){
            System.out.println("please re-input an integer between 1 and 10:");
             x = in.nextInt();
            System.out.println(ar[x-1]);
        }
            //if the input is not an integer, it will prompt the user to input an integer
        catch(InputMismatchException e){
            System.out.println("Please input an INTEGER");
            x = in.nextInt();
            System.out.println(ar[x-1]);
        }
        catch(Exception e){
            System.out.println("Error, please try again");
            x = in.nextInt();
            System.out.println(ar[x-1]);
        }
    }
}
