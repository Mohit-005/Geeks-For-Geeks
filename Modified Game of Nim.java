//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            int n = Integer.parseInt(read.readLine());
            String input_line[] = read.readLine().trim().split("\\s+");
            int A[]= new int[n];
            for(int i = 0; i < n; i++)
                A[i] = Integer.parseInt(input_line[i]);
            
            Solution ob = new Solution();
            System.out.println(ob.findWinner(n, A));
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution{
    static int findWinner(int n, int A[]){
        // code here
        int ans=0;
        for(int i:A)ans^=i;
        return ans==0?1:((n%2==0)?1:2);
    }
}
