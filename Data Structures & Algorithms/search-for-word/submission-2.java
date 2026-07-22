class Solution {
    public boolean exist(char[][] board, String word) {

        if(board == null || board.length == 0){
            return false;
        }
        boolean[][] visited = new boolean[board.length][board[0].length];
        int index = 0;
        for(int i=0; i < board.length; i++){
            for(int j=0; j <board[0].length; j++){
                    
                    // visited[i][j] = true;
                
                    if(word.charAt(0) == board[i][j]){
                        List<Character> seen = new ArrayList();              
                        if(searchBoard(board, i, j,  word, visited, index)){
                            return true;
                        }
                    }

            }
        }
        return false;
    }

    public boolean searchBoard(char[][] board, int i, int j, String word, boolean[][] visited, int index){
           
            if(i < 0 || i >= board.length || j < 0 || j >= board[0].length || visited[i][j]){
                return false;
            }
           
            
            if(board[i][j] != word.charAt(index)){
               return false;
            }
           
            
            if(index == word.length() - 1){
                return true;
            }
            visited[i][j] = true;
            if(searchBoard(board, i, j+1, word, visited, index+1) ||
            searchBoard(board, i, j-1, word, visited, index+1) ||
            searchBoard(board, i+1, j, word, visited, index+1) ||
            searchBoard(board, i-1, j, word, visited, index+1)) {
                return true;
            }

            visited[i][j] = false; 
            
            return false;

    }
}
