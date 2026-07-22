class Solution {
    public void islandsAndTreasure(int[][] grid) {
        int[][] directions = {{0,1}, {1,0}, {0,-1}, {-1,0}};
        Queue<int[]> queue = new LinkedList<>();

        if(grid == null || grid.length == 0){
            return;
        }
        for(int i =0; i < grid.length; i++){
            for(int j =0; j< grid[0].length; j++){
                if(grid[i][j]== 0){
                    queue.offer(new int[]{i, j});
                }
            }
        }
        int distance = 0; 
        while(!queue.isEmpty()){
            int size = queue.size();

            distance++;
            for(int i =0; i<size;i++){
                int[] gate = queue.poll();

                for(int[] dir:directions){
                    int x = gate[0] + dir[0];
                    int y = gate[1] + dir[1];

                    if(x<0 || y<0 || x>=grid.length|| y>=grid[0].length){
                        continue;
                    }
                    if(grid[x][y] != 2147483647 || grid[x][y]== -1){
                     continue;
                    }
                    grid[x][y] = distance;
                    queue.add(new int[]{x, y});
                }
            }
        }


        
    }

    
}
