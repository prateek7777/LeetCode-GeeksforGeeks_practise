class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix.length==0){
            return false;
        }
        
        int rows = matrix.length;
        int cols = matrix[0].length;
        int left = 0;
        int right = rows*cols-1;
        int midpoint_ele = 0;
        int midpoint = 0;
        while(left<=right){
        midpoint = left + (right-left)/2;
        midpoint_ele = matrix[midpoint/cols][midpoint%cols];
        if(midpoint_ele==target)
            return true;
        else if(midpoint_ele>=target)
            right = midpoint - 1;
        else
            left = midpoint + 1;
        }
        return false;
        
    }
}