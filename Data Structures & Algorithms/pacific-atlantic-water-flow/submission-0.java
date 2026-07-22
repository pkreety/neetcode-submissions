class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {

        

        boolean[][] canReachFromPacfic = new boolean[heights.length][heights[0].length];
        boolean[][] canReachFromAtlantic = new boolean[heights.length][heights[0].length];
        List<List<Integer>> result = new ArrayList<List<Integer>>();

       


         //pacific
        for(int i = 0; i < heights[0].length; i++){
            dfs(0, i, canReachFromPacfic, heights[0][i], heights); 
            dfs(heights.length - 1, i, canReachFromAtlantic, heights[heights.length - 1][i], heights);
        }

        //atlantic
        for(int j = 0; j < heights.length; j++){
            dfs(j , 0, canReachFromPacfic, heights[j][0], heights);
            dfs(j , heights[0].length - 1, canReachFromAtlantic, heights[j][heights[0].length - 1], heights);

        }


         for(int i = 0; i < heights.length; i++){
            for(int j = 0; j < heights[0].length; j++){
                if(canReachFromPacfic[i][j] && canReachFromAtlantic[i][j]){
                    result.add(Arrays.asList(i, j));
                }
            }
        }

     return result;
        
    }


    private void dfs(int row, int col, boolean[][] visited, int prevHeight,int [][] heights){

        if(row < 0 || row >= heights.length || col < 0 || col >= heights[0].length || visited[row][col] || prevHeight > heights[row][col]){
            return;
        }

        visited[row][col] = true;
        dfs(row + 1, col, visited, heights[row][col], heights);
        dfs(row - 1, col, visited, heights[row][col], heights);
        dfs(row, col + 1, visited, heights[row][col], heights);
        dfs(row , col - 1, visited, heights[row][col], heights);




    }
}
