import java.util.*;
public class BadSubscriptCaught {
    static int x;
    static String [] ar = {"Joe", "Matt", "Morgan", "Eddie", "Sarah", "Mike", "Emma", "Sadie", "Mark", "James"};
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        try{
            System.out.println("Input an integer to get the corresponding name:");
             x = in.nextInt();
            System.out.println(ar[x-1]);
        }
        catch(IndexOutOfBoundsException e){
            System.out.println("please re-input an integer between 1 and 10:");
             x = in.nextInt();
            System.out.println(ar[x]);
        }
        catch(InputMismatchException e){
            System.out.println("Please input an INTEGER");
            x = in.nextInt();
            system.out.println(ar[x]);
        }
    }
}
