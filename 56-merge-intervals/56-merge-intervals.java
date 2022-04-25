import java.util.Arrays.*;
class Solution {
    public int[][] merge(int[][] intervals) {
        if(intervals.length<=1)
            return intervals;
    
    
    Arrays.sort(intervals, (arr1, arr2) -> Integer.compare(arr1[0], arr2[0])); //sorting will allow us to assume that once a particular iterval is added,
                                                                               //-we need not worry about missing an interval in the next iteration.
    ArrayList<int[]> output_list = new ArrayList<>();  //we don't know the size of the final output.
    int[] current_interval = intervals[0];    //the very first interval in intervals array.
    output_list.add(intervals[0]);            //the very first interval is added to the output_list as the subsequent intervals are compared with it.
                                              //if the 2nd interval is merging with 1st interval, we modify it or else, just move ahead.
    for(int[] interval : intervals){          //iterating through the intervals.
        int current_begin = current_interval[0];  //
        int current_end = current_interval[1];
        int next_begin = interval[0];
        int next_end = interval[1];
        if(next_begin <= current_end){      //condition for merging.
            current_interval[0] = current_begin;
            current_interval[1] = Math.max(current_end, next_end);  //not current_interval[1] = next_end(because [[1,4],[1,3]] are also merging).
        }else{
            current_interval = interval;           //no merging. 
            output_list.add(current_interval); //simply add the interval to the final output.
        }
    }
    
    return output_list.toArray(new int[output_list.size()][]);  //return type is Array. So convert the ArrayList to Array.
    }
    
}