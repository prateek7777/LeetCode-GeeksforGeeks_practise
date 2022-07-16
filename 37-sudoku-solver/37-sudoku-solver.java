class Solution {
    public void solveSudoku(char[][] board) 
    {
        sodukuSolver(board, 0, 0, board.length);       //starting at (0,0). board is a square.
        return;
    }
    
    public boolean sodukuSolver(char[][] board, int currRow, int currCol, int n)
    {
        
        if(currRow == n)         //the base case. the board is of size(n-1*n-1).
            return true;
        
        int nextRow = 0;         //nextRow is calculated before the function call.
        int nextCol = 0;         //nextCol is calculated before the function call.
        
        if(currCol != n-1)       //if the end of the particular row(rightmost column) is not reached.
        {
            nextRow = currRow;   //the row will remain the same.
            nextCol = currCol+1; //the column will be incremented.
        }
        else
        {                         //if the end of the particular row(rightmost colum) is reached.
            nextRow = currRow+1;  //the row will be incremented.
            nextCol = 0;          //the column of the next row will start from 0.
        }
        
        if(board[currRow][currCol] != '.')             //the cell is not blank.(already filled). 
            return sodukuSolver(board, nextRow, nextCol, n);   //just return.
        //if cell is not filled, then proceed:
        for(char currInput = '1'; currInput<='9'; currInput++){    //the char input is used directly from the for loop. no need of converting integer to character.
            
            if(isInputValid(board, currInput, currRow, currCol, n)){      //if the particular input is valid.
                board[currRow][currCol] = currInput;        //populate the cell with that particular input.  //imp.
            
            if(sodukuSolver(board, nextRow, nextCol, n))    //the semi-base case or the temporary base case.
                return true;
          
            board[currRow][currCol] = '.';        //if the semi-base case is not reached, backtrack and start fresh with new input.
        
        } //this scope is important.
        }
        return false;     //if all the inputs are exhausted, return false.
    }
    
    public boolean isInputValid(char[][] board, char currInput, int currRow, int currCol, int n)
    {
           //the row, the column and the subgrid(3*3) must be valid.(hence, the AND operator).
        return isRowValid(board,currInput, currRow, n) &&            
               isColValid(board,currInput, currCol, n) &&
               isSubGridValid(board, currInput, currRow, currCol, n);
        
    }
    
    public boolean isRowValid(char[][] board, char currInput, int currRow, int n)
    {
        
        for(int currCol = 0; currCol < n; currCol++)              //the row will remain the same, while the column is iterated.
        {
            if(board[currRow][currCol] == currInput)            //if the cell is already filled with a valid input, ignore it.(return false).
                return false;
        }
        
        return true;                              //if the cell is valid(empty), return true.(row point of view).
    
    }
    
    public boolean isColValid(char[][] board, char currInput, int currCol, int n)
    {
      
      for(int currRow = 0; currRow<n; currRow++){                 //the column will remain the same, while the row is iterated.
          if(board[currRow][currCol] == currInput)               //if the cell is already filled with a valid input, ignore it.(return false).
              return false;
      }  
        
        return true;                               //if the cell is valid(empty), return true.(column point of view).
    }
    
    public boolean isSubGridValid(char[][] board, char currInput, int currRow, int currCol, int n){
        
        int startRowIndex = 3*(currRow/3);         //brings back the co-ordinates to (0,0). works for other subgrids as well.
        int startColIndex = 3*(currCol/3);         //brings back the co-ordinates to (0,0). works for other subgrids as well.
        //each subgrid is of size(3x3). we start checking from the beginning of each grid.
        for(int i = startRowIndex; i<=startRowIndex+2; i++){         //the rows iterate till startRow+2(<=). (startRow+2 = 3). 
            for(int j = startColIndex; j<=startColIndex+2; j++){     //the columns iterate till startCol+2(<=). (startCol+2 = 3).
                if(board[i][j] == currInput)       //if the cell is already filled with a valid input, ignore it.(return false).
                    return false;         
            }
        }
        
        return true;                        //if the cell is valid(empty), return true.(subgrid point of view).
        
 }

}