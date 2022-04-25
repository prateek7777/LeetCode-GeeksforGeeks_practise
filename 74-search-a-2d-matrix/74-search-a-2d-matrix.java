class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix.length==0){
            return false;
        }
        
        int rows = matrix.length;
        int cols = matrix[0].length;
        int left = 0; //we start with left and END with right.
        int right = rows*cols-1; //consider the 2D matrix as a 1D array. The last element would be the bottom left corner most element(rows*cols-1).
        int midpoint_ele = 0;
        int midpoint = 0;
        while(left<=right){ //don't forget this.
        midpoint = left + (right-left)/2; //we know that it is not just length/2(wrong).
        midpoint_ele = matrix[midpoint/cols][midpoint%cols]; //mxn = index. => index/n = m. Thus, rows = midpoint/colums.
                                                             //-in a way, midpoint is also an index(because of left & right).
        if(midpoint_ele==target)                                                            //[[0,1,2,3]
            return true;                                                                    //[4,5,6,7]]
        else if(midpoint_ele>=target)                                                       //=>column of index 0 = column of index 4;.
            right = midpoint - 1;//eliminate right(target not in right side).               // |||ly, column of index 1 = column of index 5.
        else                                                                                //in these kind of cases, we use modulus.
            left = midpoint + 1; //eliminate left(target not in left side).                 //Thus, columns = midpoint%cols.
        }
        return false; //we have to return something. True is being returned above, hence, returning false.
        
    }
}