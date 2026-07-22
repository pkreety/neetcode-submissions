class Solution {
    public void solve(char[][] board) {

        int row = board.length; 
        int column = board[0].length;
       // int[][] visited = new boolean[row][column];
       

        for(int i = 0; i < row; i++){
            for(int j = 0; j < column; j++){
                if(i == 0 || j == 0 || i == row - 1 || j == column - 1){
                    if(board[i][j]== 'O'){
                        dfs(board, i, j, '#', 'O');

                    }
                }
                


            }
        }

            for(int i = 0; i < row; i++){
            for(int j = 0; j < column; j++){
                
                    if(board[i][j]== 'O'){
                        dfs(board, i, j, 'X', 'O');

                    }
                
                


            }
        }

                 for(int i = 0; i < row; i++){
            for(int j = 0; j < column; j++){
               
                    if(board[i][j]== '#'){
                        dfs(board, i, j, 'O', '#');

                    }
                
                


            }
        }


        
    }

    public void dfs(char[][] board, int i, int j, char charToReplace, char charToCheck){
        if(i < 0 || i > board.length - 1 || j < 0 || j > board[0].length - 1){
            return;
        }
        if(board[i][j]!=charToCheck){
            return;
        }
        board[i][j] = charToReplace;
        dfs(board, i + 1, j, charToReplace, charToCheck);
        dfs(board, i- 1, j, charToReplace, charToCheck);
        dfs(board, i, j-1, charToReplace, charToCheck);
        dfs(board, i, j+ 1, charToReplace, charToCheck);

    }
}
