class Solution {
    public boolean exist(char[][] board, String word) {

        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[0].length; j++){

                if(word.charAt(0) == board[i][j]){

                    if(find(board,word,i,j,0,board.length,board[0].length)) return true;
                }
            }
        }

        return false;
        
    }

    public static boolean find(char[][] board, String word, int row, int col, int indx, int m, int n){

        if(indx == word.length()) return true;

        if(row < 0 || row >= m || col < 0 || col >= n) return false;

        if(word.charAt(indx) != board[row][col]) return false;

        char temp = board[row][col];
        board[row][col] = '.';

        if(find(board,word,row-1,col,indx+1,m,n)) return true;
        if(find(board,word,row+1,col,indx+1,m,n)) return true;
        if(find(board,word,row,col-1,indx+1,m,n)) return true;
        if(find(board,word,row,col+1,indx+1,m,n)) return true;

        board[row][col] = temp;

        return false;


    }
}