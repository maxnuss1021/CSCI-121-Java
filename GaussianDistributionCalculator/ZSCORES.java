import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;


public class ZSCORES {
    public static String[][] ZScores = new String[40][10];

    public ZSCORES()  {
        Scanner sc;
        try {
            sc = new Scanner(new File("/Users/maxnussbaum/Desktop/ZScoreData.csv")); //Replace this path with your own path to the ZScoreData.csv
        }
        catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        sc.useDelimiter(","); // sets the delimiter pattern
        int x = 0;
        while (sc.hasNextLine() && x < 40) {
            String line = sc.nextLine();
            String[] values = line.split(",");
            for (int y = 0; y < values.length && y < 10; y++) {
                ZScores[x][y] = values[y];
            }
            x++;
        }

    // Print the entire ZScores array
        for (String[] row : ZScores) {
            System.out.println(Arrays.toString(row));
            System.out.println(" ");

        }

        sc.close(); // closes the scanner
    }

    //takes in a z-score and give the probability
    //greater: gets the percentile from the function below and does 1 - percentile
    //less: just use percentile
    //in between: absolute value of the two percentiles minus eachother.
    public static double GetPercentile(double zScore) {
        ZSCORES z = new ZSCORES();
        double truez = zScore;
        zScore = Math.abs(zScore*100)/100;
        if (zScore == 0.0){
            return 0.50000;
        }
        //zScore += .000001;
        try {
            if (String.valueOf(zScore).substring(4, 5).equals("5")) {
                double zsc = Math.round(zScore * 100) / 100.0;
                zsc += 0.00001;
                String ZSCORE = String.valueOf(zsc);
                String first2 = ZSCORE.substring(0, 1) + ZSCORE.substring(2, 3);
                int x = Integer.valueOf(first2);
                String Last = String.valueOf(zsc).substring(3, 4);
                int y = Integer.valueOf(Last);
                if (x>40){
                    if (truez<0){
                        return 0.00001;
                    }
                   return 0.99999;
                }
                double ret = (Double.valueOf(ZScores[x][y]) + Double.valueOf(ZScores[x][y + 1])) / 2;
                ret = Math.abs(ret *100000) / 100000;
                if (truez < 0){
                    ret = 1-ret;
                }
                return ret;
            } else {
                double zsc = Math.round(zScore * 100) / 100.0;
                zsc += 0.00001;
                String ZSCORE = String.valueOf(zsc);
                String first2 = ZSCORE.substring(0, 1) + ZSCORE.substring(2, 3);
                int x = Integer.valueOf(first2);
                String Last = String.valueOf(zsc).substring(3, 4);
                int y = Integer.valueOf(Last);
                if (x>40){
                    if (truez<0){
                        return 0.00001;
                    }
                    return 0.99999;
                }
                double ret = Double.valueOf(ZScores[x][y]);
                ret = Math.abs(ret *100000) / 100000;
                if (truez < 0){
                    return 1-ret;
                }
                return ret;
            }
        }
        catch(StringIndexOutOfBoundsException e){
            double zsc = Math.round(zScore * 100) / 100.0;
            zsc += 0.0000001;
            String ZSCORE = String.valueOf(zsc);
            String first2 = ZSCORE.substring(0, 1) + ZSCORE.substring(2, 3);
            int x = Integer.parseInt(first2);
            String Last = String.valueOf(zsc).substring(3, 4);
            int y = Integer.parseInt(Last);
            if (x>40){
                if (truez<0){
                    return 0.00001;
                }
                return 0.99999;
            }
            double ret = Double.valueOf(ZScores[x][y]);
            ret = Math.abs(ret *100000) / 100000;
            if (truez < 0){
                return 1-ret;
            }
            return Double.valueOf(ZScores[x][y]);
        }
    }
}

