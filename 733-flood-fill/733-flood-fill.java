class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        //color is the new color to be put in the modified image.
        //image[sr][sc] is the color to be put in the modified image as per the image[][] array.
        if(image[sr][sc] == color)  //thus, if both are same, we just return the image[][] array without modifying it.
            return image;
        newColorFill(image, sr, sc, image[sr][sc], color);  //the function call for modifying the image array.
        return image;
    }
    
    public void newColorFill(int[][] image, int sr, int sc, int prevColor, int color){
        
     if(sr < 0 || sc < 0 || sr >= image.length || sc >= image[0].length || image[sr][sc] != prevColor)     //row and column index out of bonds is checked.
         return;  //image[sr][sc] != prevColor has to be checked at the last to avoid index out of bonds error.
     //prevColor is the integer 0 from Example 1 in the question for the which the above if condition becomes true.
     //the new color is assigned only in the four directions of a pixel(int prevColor), given that it is equal to the color present at image[sr][sc].
     image[sr][sc] = color;  //assigning the new color.
     newColorFill(image, sr-1, sc, prevColor, color);  //assigning the new color at the top.
     newColorFill(image, sr+1, sc, prevColor, color);  //assigning the new color at the bottom.
     newColorFill(image, sr, sc-1, prevColor, color);  //assigning the new color at the left.
     newColorFill(image, sr, sc+1, prevColor, color);  //assigning the new color at the right.
        
    }
}