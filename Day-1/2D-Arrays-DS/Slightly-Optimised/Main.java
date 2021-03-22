//Author: Samrat Mitra
//Slighly optimised approach.. Still the runtime is O(n^2) though
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the hourglassSum function below.
    static int hourglassSum(int[][] arr) {
        //Brute Force Approach O(n^2) Time complexity
        int num_of_rows = arr.length;
        int num_of_cols = arr[0].length;
        
        //Make the max_hourglass_sum equal to -63
        //As the constraint says that the min value of the hourglass element can be -9.. And there are 7 elements in one hourglass.. So min sum cannot be lesser than -9 * 7 = -63
        //That is why making it -63 instead of Integer.MIN_VALUE
        //It will make our code slightly optimised..
        int max_hourglass_sum = -63;
        //Traverse through the matrix
        for(int i=0; i<num_of_rows - 2; i++){
            for(int j=0; j<num_of_cols - 2; j++){
                int hourglass_top_sum = arr[i][j] + arr[i][j+1] + arr[i][j+2];
                int hourglass_middle_sum = arr[i+1][j+1];
                int hourglass_bottom_sum = arr[i+2][j] + arr[i+2][j+1] + arr[i+2][j+2];
                
                int curr_hourglass_sum = hourglass_top_sum + hourglass_middle_sum + hourglass_bottom_sum;
                //As we need the max hourglass sum
                //So comparing the current sum with the max_sum
                max_hourglass_sum = Math.max(max_hourglass_sum, curr_hourglass_sum);
            }
        }
        return max_hourglass_sum;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int[][] arr = new int[6][6];

        for (int i = 0; i < 6; i++) {
            String[] arrRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 6; j++) {
                int arrItem = Integer.parseInt(arrRowItems[j]);
                arr[i][j] = arrItem;
            }
        }

        int result = hourglassSum(arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
