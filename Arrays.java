import java.util.*;
public class Arrays {
    public static void main(String[] args ){
        System.out.println("Welcome to the number tracker, you can enter up to 20 different numbers.");
        Scanner in = new Scanner(System.in);
        double [] ary = new double[20];
        int x = 0;
        int i = 0;
        while (x != 99999){
            System.out.println("What is your next double? (type 99999 to quit)");
            double w = in.nextDouble();
            if (w != 99999.0){
                ary[i] = w;
                i++;
            }
            else{
                x = 99999;
            }
        }
        if (i == 0 ){
            System.out.println("ERROR: NO DOUBLES HAVE BEEN ENTERED");
        }
        else{
            System.out.println("These are your numbers.");
            for (int n = 0; n< i; n++){
                System.out.println(ary[n]);
            }
        }
    }

}
