//Author: Samrat Mitra(Taken help from Cracking the coding interview book by Gayle Lackermann McDowell)
//Used Heaps to implement the logic because the Brute force takes O(n^2)
//This is the optimap solution
import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;

public class Solution {

    /*
     * Complete the runningMedian function below.
     */
    //First let us design the addNumber function
    //This will add the number to the heap..
    public static void addNumber(int number, PriorityQueue<Integer> lowers, PriorityQueue<Integer> highers){
        //If number is lower than the root or the heap is empty add the number to the heap
        if(lowers.size() == 0 || number < lowers.peek()){
            lowers.add(number);
        }else{
            highers.add(number);
        }
    }
    //Create the balance function
    public static void balance(PriorityQueue<Integer> lowers, PriorityQueue<Integer> highers){
        PriorityQueue<Integer> biggerHeap = lowers.size() > highers.size() ? lowers : highers;
        PriorityQueue<Integer> smallerHeap = lowers.size() > highers.size() ? highers : lowers;
        
        //then balancing logic comes here
        if(biggerHeap.size() - smallerHeap.size() >= 2){
            //It will never exceed 2 though
            //PriorityQueue. poll() method in Java is used to retrieve or fetch and remove the first element of the Queue or the element present at the head of the Queue. 
            //The peek() method only retrieved the element at the head but the poll() also removes the element along with the retrieval.
            smallerHeap.add(biggerHeap.poll());
        }
    }
    //Find median using the getMedian method
    public static double getMedian(PriorityQueue<Integer> lowers, PriorityQueue<Integer> highers){
        PriorityQueue<Integer> biggerHeap = lowers.size() > highers.size() ? lowers : highers;
        PriorityQueue<Integer> smallerHeap = lowers.size() > highers.size() ? highers : lowers;
        
        if(biggerHeap.size() == smallerHeap.size()){
            //Means we have even number of elements for finding the running median
            double median = (double)(biggerHeap.peek() + smallerHeap.peek())/2;
            return median;
        }else{
            return biggerHeap.peek();
        }
    }
     
    static double[] runningMedian(int[] a) {
        //We need two heaps
        //One max heap for storing values, lesser than the median of the array
        PriorityQueue<Integer> lowers = new PriorityQueue<Integer>(new Comparator<Integer>(){
           //This comparator is used to make it max heap..
           public int compare(Integer a, Integer b){
               return -1 * a.compareTo(b);
           } 
        });
        //One min heap for storing values, greater than the median of the array 
        PriorityQueue<Integer> highers = new PriorityQueue<Integer>();
        //Create an array to store the calculated medians
        double[] medians = new double[a.length];
        
        for(int i=0; i<a.length; i++){
            int number = a[i];
            //add number to the heap
            addNumber(number, lowers, highers);
            //Balance the heap, to make the two heaps of size as close as possible
            balance(lowers, highers);
            //Store the calculated medians
            medians[i] = getMedian(lowers, highers);
        }
        //return the medians array
        return medians;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int aCount = Integer.parseInt(scanner.nextLine().trim());

        int[] a = new int[aCount];

        for (int aItr = 0; aItr < aCount; aItr++) {
            int aItem = Integer.parseInt(scanner.nextLine().trim());
            a[aItr] = aItem;
        }

        double[] result = runningMedian(a);

        for (int resultItr = 0; resultItr < result.length; resultItr++) {
            bufferedWriter.write(String.valueOf(result[resultItr]));

            if (resultItr != result.length - 1) {
                bufferedWriter.write("\n");
            }
        }

        bufferedWriter.newLine();

        bufferedWriter.close();
    }
}
