class Solution {
    public void solveSudoku(char[][] board) 
    {
        sodukuSolver(board, 0, 0, board.length);
        return;
    }
    
    public boolean sodukuSolver(char[][] board, int currRow, int currCol, int n)
    {
        
        if(currRow == n)
            return true;
        
        int nextRow = -1;
        int nextCol = -1;
        
        if(currCol != n-1)
        {
            nextRow = currRow;
            nextCol = currCol+1;
        }
        else
        {
            nextRow = currRow+1;
            nextCol = 0;
        }
        
        if(board[currRow][currCol] != '.')
            return sodukuSolver(board, nextRow, nextCol, n);
        
        for(char currInput = '1'; currInput<='9'; currInput++){
            
            if(isInputValid(board, currInput, currRow, currCol, n)){
                board[currRow][currCol] = currInput;                //imp.
            
            if(sodukuSolver(board, nextRow, nextCol, n))
                return true;
          
            board[currRow][currCol] = '.';
        
        }
        }
        return false;
    }
    
    public boolean isInputValid(char[][] board, char currInput, int currRow, int currCol, int n)
    {
    
        return isRowValid(board,currInput, currRow, n) &&
               isColValid(board,currInput, currCol, n) &&
               isSubGridValid(board, currInput, currRow, currCol, n);
        
    }
    
    public boolean isRowValid(char[][] board, char currInput, int currRow, int n)
    {
        
        for(int currCol = 0; currCol < n; currCol++)
        {
            if(board[currRow][currCol] == currInput)
                return false;
        }
        
        return true;
    
    }
    
    public boolean isColValid(char[][] board, char currInput, int currCol, int n)
    {
      
      for(int currRow = 0; currRow<n; currRow++){
          if(board[currRow][currCol] == currInput)
              return false;
      }  
        
        return true;
    }
    
    public boolean isSubGridValid(char[][] board, char currInput, int currRow, int currCol, int n){
        
        int startRowIndex = 3*(currRow/3);
        int startColIndex = 3*(currCol/3);
        
        for(int i = startRowIndex; i<=startRowIndex+2; i++){
            for(int j = startColIndex; j<=startColIndex+2; j++){
                if(board[i][j] == currInput)
                    return false;
            }
        }
        
        return true;
        
 }

    
}
