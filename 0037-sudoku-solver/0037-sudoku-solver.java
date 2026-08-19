class Solution {
    public void solveSudoku(char[][] board) {
        solve(board);
    }
    public boolean solve(char[][]board){
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(board[i][j]=='.'){
                    for(char ch='1';ch<='9';ch++){
                        if(isValid(board,i,j,ch)==true){
                            board[i][j]=ch;
                            if(solve(board)==true){
                                return true;
                            }else{
                                board[i][j]='.';
                            }  
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }
    public boolean isValid(char[][] board, int row, int col, char c) {
 
        for (int i = 0; i < 9; i++) {
            if (board[i][col] == c) return false;
        }

        for (int j = 0; j < 9; j++) {
            if (board[row][j] == c) return false;
        }

        int boxRowStart = 3 * (row / 3);
        int boxColStart = 3 * (col / 3);

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[boxRowStart + i][boxColStart + j] == c) return false;
            }
        }
        return true;
    }
}