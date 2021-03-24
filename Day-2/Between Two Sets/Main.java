import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'getTotalX' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY a
     *  2. INTEGER_ARRAY b
     */

    //Author: Samrat Mitra
    public static int getTotalX(List<Integer> a, List<Integer> b) {
        //Take the LCM of the entire first arraylist elements
        int lcm_first = a.get(0);
        for(int i=1; i<a.size(); i++){
            lcm_first = lcm(lcm_first, a.get(i));
        }
        //Take the GCD of the entire second arraylist elements
        int gcd_second = b.get(0);
        for(int i=1; i<b.size(); i++){
            gcd_second = gcd(gcd_second, b.get(i));
        }
        //Store the values between lcm_first and gcd_second incremented by the lcm_first in an arraylist
        List<Integer> list = new ArrayList<>();
        
        int temp = lcm_first;
        while(temp <= gcd_second){
            list.add(temp);
            temp += lcm_first;
        }
        
        int count = 0;
        for(int itr1: list){
            boolean isMultiple = true;
            for(int itr2: b){
                if(itr2 % itr1 != 0){
                    isMultiple = false;
                    break;
                }
            }
            if(isMultiple){
                count++;
            }
        }
        return count;
    }
    
    //GCD Function
    public static int gcd(int a, int b){
        if(b == 0) return a;
        else return gcd(b, a % b);
    }
    //LCM Function
    public static int lcm(int a, int b){
        return (a * b) / gcd(a, b);
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int m = Integer.parseInt(firstMultipleInput[1]);

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        List<Integer> brr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        int total = Result.getTotalX(arr, brr);

        bufferedWriter.write(String.valueOf(total));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
