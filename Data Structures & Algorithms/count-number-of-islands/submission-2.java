class Solution {
    public int numIslands(char[][] grid) {

        int result = 0;
        boolean[][] visited = new boolean[grid.length][grid[0].length]; 
        for(int i = 0; i < grid.length; i++){
            for(int j =0; j < grid[0].length; j++){

                if(grid[i][j] == '1' && !visited[i][j]){
                    checkIfItsIsaland(i, j, visited, grid);
                    result++;
                }
            }
        }
    return result;
        
    }

    public void checkIfItsIsaland(int i, int j, boolean[][] visited, char[][] grid){
        if(i < 0 || i >= grid.length || j >= grid[0].length || j < 0 || visited[i][j] || grid[i][j] == '0'){
            return;
        }
        visited[i][j] = true;

        checkIfItsIsaland(i+1, j, visited, grid);
        checkIfItsIsaland(i-1, j, visited, grid);
        checkIfItsIsaland(i, j-1, visited, grid);
        checkIfItsIsaland(i, j+1, visited, grid);

    }
}
