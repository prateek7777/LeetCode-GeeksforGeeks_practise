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
        
        ArrayList<Integer> answer = new ArrayList<>();        //ArrayList as we don't know the exact size of the final result.
        HashMap<Integer,Integer> memo = new HashMap<>();
        int distinct = 0;
        int currValue = 0;
        int discardElement = 0;
        int release = 0;
        //the Sliding Window technique is used here.
        for(int i=0; i<k; i++){                               //we have to start from 0 to k. k = size of the subarray.
            
            currValue = A[i];
            
            if(memo.containsKey(currValue))
            memo.put(currValue, memo.get(currValue)+1);
            else
            {
                memo.put(currValue, 1);                      //if the number of the array has been encountered for the first time.
                distinct = distinct + 1;                     //incrementing the distinct.
            }
            
        }
        
        answer.add(distinct);                                //adding the distinct as the element of the output ArrayList.
        
        release = 0;                                         //initialising release pointer to 0.
        for(int acquire = k; acquire<n; acquire++){          //we start acquire pointer from k as we have already iterated through elements from 0 to k in the previous(first)
                                                             //for loop.             
            discardElement = A[release];  //but, before acquiring, we have to discard an element as the subarray size cannot be (k+1). 
            
            memo.put(discardElement, memo.get(discardElement)-1);  //discard without any "if" loop.
            release = release + 1;                                 //increment release pointer which is used to point to elements to be discarded.
            
            if(memo.get(discardElement) == 0){                //if the count(frequency) of the element to be discarded is 0 already.
                memo.remove(discardElement);                  //remove that element from the HashMap.
                distinct = distinct - 1;         //decrement discard ONLY if the element is removed from the HashMap.
            }
            
            currValue = A[acquire];              //element to be acquired into the subarray
            
            if(memo.containsKey(currValue))                //same logic as elements iterated from 0 to k.
            memo.put(currValue, memo.get(currValue)+1);
            else{
                memo.put(currValue, 1);
                distinct = distinct + 1;
            }
            
            answer.add(distinct);                          //adding the distinct as the element of the output ArrayList.
        
        }
        
        return answer;                             //returning the final output ArrayList.
        
    }
}

