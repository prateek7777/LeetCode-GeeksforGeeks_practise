class Solution {
    public List<List<String>> solveNQueens(int n){        //main function.
        List<List<String>> answer = new ArrayList<>();
        char[][] board = new char[n][n];                //create a board of chars.
        
        for(int i = 0; i<n; i++){
            for(int j = 0; j<n; j++){
                board[i][j] = '.';         //initialize the cells of the board with '.' which represents empty cells.
            }
        }
        
        nQueens(board, 0, n, answer);     //the main recursive function call.
        return answer;
    }
    
    public void nQueens(char[][] board, int currRow, int n, List<List<String>> answer){
        if(currRow == n){             //the lower end of the board has been reached without any backtrack.(nxn chessboard).
            answer.add(convertAns(board, n));   //the currentAnswer(subAnswer of one string list) is added to the answer list.
            return;
        }
        
        for(int currCol = 0; currCol < n; currCol++){        //the column is iterated with queen being put at each cell in the column without iterating the row.(left to right).
        
            if(isInputValid(board, currRow, currCol, n)){    //if the cell is valid for the queen to be put.
                board[currRow][currCol] = 'Q';             //populate the cell with 'Q'.                    //choose.
                nQueens(board, currRow+1, n, answer);      //go for the next row as two queens cannot be present in the same row.    //explore.
                board[currRow][currCol] = '.';             //backtrack.     //unchoose. //while returning we convert the cell into its previous state.
            }
            
        }
        
        return;
    }
    
    public List<String> convertAns(char[][] board, int n){
        List<String> currAnswer = new ArrayList<>();
        //converting the answer from board[][] = [][] to currAnswer = [currRowString, currRowString].
        for(int i=0; i<n; i++){
            String currRowString = "";    //for every new row, the string is re-initialized.
            for(int j=0; j<n; j++){       
                currRowString = currRowString + board[i][j];  //the column cells are put in currRowString as per their data.(left to right).
            }
                     
        currAnswer.add(currRowString);    //adding the currRowString to list currAnswer. this will repeat for all rows(i).
        }
        return currAnswer;
    }
    
    public boolean isInputValid(char[][] board, int currRow, int currCol, int n){
        //for the input to be valid, any movement in row, column and the diagonal should be valid.
        return isRowValid(board, currRow, n) &&
               isColValid(board, currCol, n) &&
               isDiagonalValid(board, currRow, currCol, n);
    }
    
    public boolean isRowValid(char[][] board, int currRow, int n){
        //the entire row is iterated throughout its columns by keeping itself constant for each "for" loop iteration.(left to right in each call.)
    for(int currCol = 0; currCol<n; currCol++){
        
        if(board[currRow][currCol] == 'Q')         //if the cell is already populated, its invalid.
            return false;
    }
    
    return true;
    } 
    
    public boolean isColValid(char[][] board, int currCol, int n){
        //the entire column is iterated throughout its rows by keeping itself constant for each "for" loop iteration.(top to bottom in each call.)
        for(int currRow=0; currRow<n; currRow++){
            
            if(board[currRow][currCol] == 'Q')      //if the cell is already populated, its invalid.
                return false;
            
        }
        
        return true;
    }
    
    public boolean isDiagonalValid(char[][] board, int currRow, int currCol, int n){
        //the diagonal too has to be valid.
        int x = currRow;
        int y = currCol;
    //the left lower diagonal and the right lower diagonal are not checked(not necessary), because we don't populate the lower rows without populating the upper ones first. we go from top to bottom.
        
        //left upper diagonal
        while(x>=0 && y>=0){          //the condition for the iteration.(to avoid index out of bounds error.)
            
            if(board[x][y] == 'Q')         //if the cell is already populated, its invalid.
                return false;
            
            x=x-1;                      //the iteration.
            y=y-1;
        }
        
        x = currRow;                //re-initialize the currRow and currCol for the iteration in the right upper diagonal to avoid index out of bonds error.
        y = currCol;
        //right upper diagonal
        while(x>=0 && y<=n-1){      //the condition for the iteration.(to avoid index out of bounds error.)
            
            if(board[x][y] == 'Q')        //if the cell is already populated, its invalid.
                return false;
        
            x=x-1;                  //the iteration.
            y=y+1;
    }
        
        return true;
    
}
}