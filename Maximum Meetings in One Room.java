//{ Driver Code Starts
import java.io.*;
import java.util.*;


class IntArray
{
    public static int[] input(BufferedReader br, int n) throws IOException
    {
        String[] s = br.readLine().trim().split(" ");
        int[] a = new int[n];
        for(int i = 0; i < n; i++)
            a[i] = Integer.parseInt(s[i]);
        
        return a;
    }
    
    public static void print(int[] a)
    {
        for(int e : a)
            System.out.print(e + " ");
        System.out.println();
    }
    
    public static void print(ArrayList<Integer> a)
    {
        for(int e : a)
            System.out.print(e + " ");
        System.out.println();
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            
            int N; 
            N = Integer.parseInt(br.readLine());
            
            
            int[] S = IntArray.input(br, N);
            
            
            int[] F = IntArray.input(br, N);
            
            Solution obj = new Solution();
            ArrayList<Integer> res = obj.maxMeetings(N, S, F);
            
            IntArray.print(res);
            
        }
    }
}

// } Driver Code Ends


class Solution {
    public static ArrayList<Integer> maxMeetings(int N, int[] S, int[] F) {
        // code here
        int[][] P = new int[N][3];
        for(int i = 0 ; i < N ; i++){
            P[i][0] = S[i];
            P[i][1] = F[i];
            P[i][2] = i + 1;
        }
        Arrays.sort(P , (a , b) -> a[1] == b[1] ? a[0] == b[0] ? a[2] - b[2] : a[0] - b[0] : a[1] - b[1]);
        ArrayList<Integer> ans = new ArrayList<>();
        int las = P[0][1];
        ans.add(P[0][2]);
        
        for(int i = 1 ; i < N ; i++){
            if(las < P[i][0]){
                las = P[i][1];;
                ans.add(P[i][2]);
            }
        }
        Collections.sort(ans);
        return ans;
    }
}
        
