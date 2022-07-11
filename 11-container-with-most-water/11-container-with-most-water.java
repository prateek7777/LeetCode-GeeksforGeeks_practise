class Solution {
    public int maxArea(int[] height) {
        int maxArea = 0;
        int aPointer = 0;
        int bPointer = height.length-1;
        
        while(aPointer < bPointer){
         
            if(height[aPointer] < height[bPointer]){
                maxArea = Math.max(maxArea, height[aPointer]*(bPointer-aPointer));
                aPointer++;
            }
            
            else
            {
                maxArea = Math.max(maxArea, height[bPointer]*(bPointer-aPointer));
                bPointer--;
            }
  
        }
        return maxArea;
    }
}