//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class Job {
    int id, profit, deadline;
    Job(int x, int y, int z){
        this.id = x;
        this.deadline = y;
        this.profit = z; 
    }
}

class GfG {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        //testcases
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0){
            String inputLine[] = br.readLine().trim().split(" ");
            
            //size of array
            int n = Integer.parseInt(inputLine[0]);
            Job[] arr = new Job[n];
            inputLine = br.readLine().trim().split(" ");
            
            //adding id, deadline, profit
            for(int i=0, k=0; i<n; i++){
                arr[i] = new Job(Integer.parseInt(inputLine[k++]), Integer.parseInt(inputLine[k++]), Integer.parseInt(inputLine[k++]));
            }
            
            Solution ob = new Solution();
            
            //function call
            int[] res = ob.JobScheduling(arr, n);
            System.out.println (res[0] + " " + res[1]);
        }
    }
}
// } Driver Code Ends


class Solution
{
    //Function to find the maximum profit and the number of jobs done.
    int[] JobScheduling(Job arr[], int n)
    {
        // Your code here
        Arrays.sort(arr,(a,b)-> b.profit-a.profit);
        int maxD=0;
        for(Job i:  arr)
        {
            maxD=Math.max(i.deadline,maxD);
        }
        int[] res=new int[maxD+1];
        for(int i=1;i<=maxD;i++)
            res[i]=-1;
        
        int c=0, ans=0;
        
        for(int i=0;i<n;i++)
        {
            for(int j=arr[i].deadline;j>0;j--)
            {
                if(res[j]==-1)
                {
                    res[j]=arr[i].id;
                    ans+=arr[i].profit;
                    c++;
                    break;
                }
            }
        }
        int ansArr[]={c,ans};
        return ansArr;
    }
}
