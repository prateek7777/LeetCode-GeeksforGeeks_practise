class Solution {
    public List<List<String>> solveNQueens(int n){
        List<List<String>> answer = new ArrayList<>();
        char[][] board = new char[n][n];
        
        for(int i = 0; i<n; i++){
            for(int j = 0; j<n; j++){
                board[i][j] = '.';
            }
        }
        
        nQueens(board, 0, n, answer);
        return answer;
    }
    
    public void nQueens(char[][] board, int currRow, int n, List<List<String>> answer){
        if(currRow == n){
            answer.add(convertAns(board, n));
            return;
        }
        
        for(int currCol = 0; currCol < n; currCol++){
        
            if(isInputValid(board, currRow, currCol, n)){
                board[currRow][currCol] = 'Q';
                nQueens(board, currRow+1, n, answer);
                board[currRow][currCol] = '.';
            }
            
        }
        
        return;
    }
    
    public List<String> convertAns(char[][] board, int n){
        List<String> currAnswer = new ArrayList<>();
        
        for(int i=0; i<n; i++){
            String currRowString = "";
            for(int j=0; j<n; j++){
                currRowString = currRowString + board[i][j];
            }
                     
        currAnswer.add(currRowString);
        }
        return currAnswer;
    }
    
    public boolean isInputValid(char[][] board, int currRow, int currCol, int n){
        
        return isRowValid(board, currRow, n) &&
               isColValid(board, currCol, n) &&
               isDiagonalValid(board, currRow, currCol, n);
    }
    
    public boolean isRowValid(char[][] board, int currRow, int n){
        
    for(int currCol = 0; currCol<n; currCol++){
        
        if(board[currRow][currCol] == 'Q')
            return false;
    }
    
    return true;
    }
    
    public boolean isColValid(char[][] board, int currCol, int n){
        
        for(int currRow=0; currRow<n; currRow++){
            
            if(board[currRow][currCol] == 'Q')
                return false;
            
        }
        
        return true;
    }
    
    public boolean isDiagonalValid(char[][] board, int currRow, int currCol, int n){
        
        int x = currRow;
        int y = currCol;
        
        //left upper diagonal
        
        while(x>=0 && y>=0){
            
            if(board[x][y] == 'Q')
                return false;
            
            x=x-1;
            y=y-1;
        }
        
        x = currRow;
        y = currCol;
        //right upper diagonal
        while(x>=0 && y<=n-1){
            
            if(board[x][y] == 'Q')
                return false;
        
            x=x-1;
            y=y+1;
    }
        
        return true;
    
}
}