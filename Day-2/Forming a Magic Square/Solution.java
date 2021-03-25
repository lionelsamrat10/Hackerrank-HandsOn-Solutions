//Author: Samrat Mitra
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the formingMagicSquare function below.
    static int formingMagicSquare(int[][] s) {
        //Taking all possible magic squares
        //Because only 8 possible magic squares can be formed for a 3 X 3 Matrix
        int[][] magicSquare1 = { { 8, 1, 6 }, { 3, 5, 7 }, { 4, 9, 2 } };
        int[][] magicSquare2 = { { 6, 1, 8 }, { 7, 5, 3 }, { 2, 9, 4 } };
        int[][] magicSquare3 = { { 4, 9, 2 }, { 3, 5, 7 }, { 8, 1, 6 } };
        int[][] magicSquare4 = { { 2, 9, 4 }, { 7, 5, 3 }, { 6, 1, 8 } };
        int[][] magicSquare5 = { { 8, 3, 4 }, { 1, 5, 9 }, { 6, 7, 2 } };
        int[][] magicSquare6 = { { 4, 3, 8 }, { 9, 5, 1 }, { 2, 7, 6 } };
        int[][] magicSquare7 = { { 6, 7, 2 }, { 1, 5, 9 }, { 8, 3, 4 } };
        int[][] magicSquare8 = { { 2, 7, 6 }, { 9, 5, 1 }, { 4, 3, 8 } };
        
        //Add the all possible magic squares into an arraylist
        ArrayList<int[][]> magicSquares = new ArrayList<>();
        magicSquares.add(magicSquare1);
        magicSquares.add(magicSquare2);
        magicSquares.add(magicSquare3);
        magicSquares.add(magicSquare4);
        magicSquares.add(magicSquare5);
        magicSquares.add(magicSquare6);
        magicSquares.add(magicSquare7);
        magicSquares.add(magicSquare8);
        
        int minCost = Integer.MAX_VALUE;
        //Traversing through the arraylist and finding the cost
        for(int[][] itr: magicSquares){
            int currCost = 0;
            for(int i=0; i<itr.length; i++){
                for(int j=0; j<itr.length; j++){
                    currCost += Math.abs(itr[i][j] - s[i][j]);
                }
            }
            minCost = Math.min(minCost, currCost);
        }
        return minCost;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int[][] s = new int[3][3];

        for (int i = 0; i < 3; i++) {
            String[] sRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 3; j++) {
                int sItem = Integer.parseInt(sRowItems[j]);
                s[i][j] = sItem;
            }
        }

        int result = formingMagicSquare(s);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
