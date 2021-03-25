import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the isBalanced function below.
    static String isBalanced(String s) {
        //Taking an arrayDeque instead of Stack for faster runtime
        Deque<Character> stack = new ArrayDeque<Character>();
        //Traverse the string
        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            
            if(ch == '(' || ch == '{' || ch == '['){
                //Push it onto stack
                stack.push(ch);
                continue;
            }
            //If current char is not opening bracket, then it must be a closing one..
            //So, stack can't be empty at that point
            if(stack.isEmpty()){
                return "NO";
            }
            char check;
            
            switch(ch){
                case ')':
                check = stack.pop();
                if(check == '{' || check == '['){
                    return "NO";
                }
                break;
                
                case '}':
                check = stack.pop();
                if(check == '(' || check == '['){
                    return "NO";
                }
                break;
                
                case ']':
                check = stack.pop();
                if(check == '{' || check == '('){
                    return "NO";
                }
                break;
            }
        }
      //If Stack is empty, then the parenthesis is balanced, else it is not balanced..
        return stack.isEmpty() ? "YES" : "NO";
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            String s = scanner.nextLine();

            String result = isBalanced(s);

            bufferedWriter.write(result);
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
