class Solution {
    public int maxArea(int[] height) {
        int maxArea = 0;
        int aPointer = 0;    //pointer from left end.
        int bPointer = height.length-1;  //pointer from right end.
        //both the pointers are made to move inwards, with maxArea being updated(if required) at each point.        
        while(aPointer < bPointer){    //until both the pointers meet.
            if(height[aPointer] < height[bPointer]){ //the smaller height and the area created by it is common to both the heights. hence, the smaller height is considered.    
                maxArea = Math.max(maxArea, height[aPointer]*(bPointer-aPointer)); //(bPointer-aPointer) is the breadth.
                aPointer++;  //moving inwards.
            }
            else
            {
                maxArea = Math.max(maxArea, height[bPointer]*(bPointer-aPointer));
                bPointer--;  //moving inwards.
            }
        }
        return maxArea;
    }
}