// { Driver Code Starts
import java.util.*;
import java.io.*;
import java.util.HashMap;

class GFG
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0)
        {
            int n = sc.nextInt();
            int k = sc.nextInt();
            int a[] = new int[n];
            for (int i = 0; i < n; i++) 
                a[i] = sc.nextInt();
            Solution g = new Solution();
            
            ArrayList<Integer> ans = g.countDistinct(a, n, k);

            for (Integer val: ans) 
                System.out.print(val+" "); 
            System.out.println();
            t--;
        }
    }
}// } Driver Code Ends


class Solution
{
    ArrayList<Integer> countDistinct(int A[], int n, int k)
    {
        
        ArrayList<Integer> answer = new ArrayList<>();
        HashMap<Integer,Integer> memo = new HashMap<>();
        int distinct = 0;
        int currValue = 0;
        int discardElement = 0;
        int release = 0;

        for(int i=0; i<k; i++){
            
            currValue = A[i];
            
            if(memo.containsKey(currValue))
            memo.put(currValue, memo.get(currValue)+1);
            else
            {
                memo.put(currValue, 1);
                distinct = distinct + 1;
            }
            
        }
        
        answer.add(distinct);
        
        release = 0;
        for(int acquire = k; acquire<n; acquire++){
            
            discardElement = A[release];
            
            memo.put(discardElement, memo.get(discardElement)-1);
            release = release + 1;
            
            if(memo.get(discardElement) == 0){
                memo.remove(discardElement);
                distinct = distinct - 1;
            }
            
            currValue = A[acquire];
            
            if(memo.containsKey(currValue))
            memo.put(currValue, memo.get(currValue)+1);
            else{
                memo.put(currValue, 1);
                distinct = distinct + 1;
            }
            
            answer.add(distinct);
        
        }
        
        return answer;
        
    }
}

