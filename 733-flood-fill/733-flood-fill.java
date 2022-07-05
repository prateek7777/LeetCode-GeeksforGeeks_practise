class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if(image[sr][sc] == color)
            return image;
        newColorFill(image, sr, sc, image[sr][sc], color);
        return image;
    }
    
    public void newColorFill(int[][] image, int sr, int sc, int prevColor, int color){
        
     if(sr < 0 || sc < 0 || sr >= image.length || sc >= image[0].length || image[sr][sc] != prevColor)
         return;
        
     image[sr][sc] = color;
     newColorFill(image, sr-1, sc, prevColor, color);
     newColorFill(image, sr+1, sc, prevColor, color);
     newColorFill(image, sr, sc-1, prevColor, color);
     newColorFill(image, sr, sc+1, prevColor, color);

    }
}