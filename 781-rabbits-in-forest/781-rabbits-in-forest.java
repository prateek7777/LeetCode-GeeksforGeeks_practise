class Solution {
    public int numRabbits(int[] answers) {
        double answer = 0;                                    //double is used, because Math.ceil() gives a floating integer output.
        HashMap<Integer, Integer> memo = new HashMap<>();
        
        for(int currReportee : answers){   //the currReportee is the rabbit telling the number of rabbits OTHER than it, belonging to the same colour group as it.
            //currReportee count is 1 less, because the rabbit(currReportee) is not including itself.
            if(memo.containsKey(currReportee))
                memo.put(currReportee, memo.get(currReportee)+1);         //memo.get(currReportee) represents the count of the same colour group rabbits.
            
            else
                memo.put(currReportee, 1);
            
        }
        
        for(Integer currKey : memo.keySet()){                     //iterating through the HashMap.
     
            double groupSize = currKey + 1;  //the groupSize is the size of the ENTIRE group of same colour rabbits.
            //-as the rabbit is not counting itself, we add 1 to currKey(currKey is the value present at currReportee).
            double numGroups = Math.ceil(memo.get(currKey)/groupSize);     //number of groups = frequency/group size. if frequency=10, group size = 5, number of groups = 2 (10/5).
            //consider frequency = 3, group size = 2, then number of groups = 1(3/2), but we cannot put 3 rabbits in 1 group having size=2. Thus, Math.ceil() gives us the upper limit of (3/2).
            //thus, Math.ceil(3/2) = 2. we put 2 rabbits in the first group, further, we put 1 rabbit in the second group.
            answer = answer + (numGroups*groupSize);   //the required answer is the minimum number of rabbits that could be in the forest. this number is given by the multiplication of the 
            //number of groups and the size of that particular group. Here, groupSize and numGroups are changing with each iteration, and the answer is getting updated as well.
        }
            return (int)answer;               //we type cast the answer from double to int as the required return type is int.
    }
}