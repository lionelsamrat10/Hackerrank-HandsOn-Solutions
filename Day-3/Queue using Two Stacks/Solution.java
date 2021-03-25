//Author: Samrat Mitra
import java.io.*;
import java.util.*;

public class Solution {
    //Take two stacks
    private static Stack<Integer> input = new Stack();
    private static Stack<Integer> output = new Stack();
    //Perform the enqueue operation
    public static void enqueue(int ele){
        input.push(ele);
    }
    //Perform the dequeue operation
    public static int dequeue(){
        peek();
        //return the top element from the output stack 
        return output.pop();
    }
    //Peek() operation
    public static int peek(){
        //check if output stack is empty or not
        if(output.empty()){
            //pop elements from the input stack and push them onto the output stack
            while(!input.empty()){
                output.push(input.pop());
            }
        }
        //call the peek()
        return output.peek();
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int q = sc.nextInt();
        
        while(q-- > 0){
            int type = sc.nextInt();
            
            switch(type){
                case 1:
                    int ele = sc.nextInt();
                    enqueue(ele);
                    break;
                case 2:
                    int deleted_element = dequeue();
                    break;
                case 3:
                    int peekedItem = peek();
                    System.out.println(peekedItem);
                    break;
            }
        }
    }
}
 
