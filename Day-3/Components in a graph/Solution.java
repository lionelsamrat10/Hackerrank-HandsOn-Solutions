//Author: Samrat Mitra
//Used Union Find Algorithm
import java.io.*;
import java.util.*;

public class Solution{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        UF uf = new UF();
        uf.init(2 * n);
        
        for(int i=1; i<=n; i++){
            int g = sc.nextInt();
            int b = sc.nextInt();
            //Find the union
            uf.union(g, b);
        }
        
        int maxSize = Integer.MIN_VALUE, minSize = Integer.MAX_VALUE;
        //As there are 2*n number of nodes in the graph
        for(int i=1; i<=2*n; i++){
            int p = uf.find(i);
            int s = uf.size[p];
            
            if(s > 1){
                if(minSize > s){
                    minSize = s;
                }
                if(maxSize < s){
                    maxSize = s;
                }
            }
        }
        //Print the minimum and maximum values
        System.out.println(minSize + " " + maxSize);
    }
    //Static inner class for implementing Union Find Algorithm
    static class UF{
        //MAXN is initialized with 30001, because number of nodes cannot exceed 2 * 15000 = 30000
        final static int MAXN = 30001;
        int parent[] = new int[MAXN];
        int size[] = new int[MAXN];
        //init method
        public void init(int n) {
            for (int i = 1; i <= n; i++) {
                parent[i] = i;
                size[i] = 1;
            }
        }
        //method to find the union
        public void union(int u, int v){
            int i = find(u);
            int j = find(v);
            
            if(i == j){
                //Means disconnected vertex
                return;
            }
            parent[i] = j;
            size[j] += size[i];
        }
        //find() method
        public int find(int u){
            if(parent[u] == u){
                return u;
            }else{
               return parent[u] = find(parent[u]); 
            }
        }
    }
}
