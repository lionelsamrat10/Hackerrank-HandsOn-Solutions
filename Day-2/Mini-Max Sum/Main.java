//Author: Samrat Mitra
//T(n) = O(n) Because only one traversal is enough to solve the problem...

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the miniMaxSum function below.
    static void miniMaxSum(int[] arr) {
        //First let us find the sum of all the elements in the array
        long sum = 0;
        for(int i: arr){
            sum += i;
        }
        //Find max and min from array
        long maxi = Integer.MIN_VALUE, mini = Integer.MAX_VALUE;
        for(int i=0; i<arr.length; i++){
            if(arr[i] > maxi) maxi = arr[i];
            if(arr[i] < mini) mini = arr[i];
        }
        System.out.println((sum-maxi) + " " + (sum-mini));
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int[] arr = new int[5];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < 5; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        miniMaxSum(arr);

        scanner.close();
    }
}
