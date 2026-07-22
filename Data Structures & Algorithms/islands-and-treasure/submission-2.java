class Solution {
    public void islandsAndTreasure(int[][] grid) {
        if(grid == null || grid.length == 0){
            return;
        }
        int[][] directions = new int[][] {{1,0}, {-1,0}, {0, 1}, {0, -1}};

        Queue<int[]> queue = new LinkedList<>();
        for(int i =0; i <grid.length; i++){
            for(int j =0; j <grid[0].length;j++){

                if(grid[i][j] == 0){
                    queue.offer(new int[] {i, j});
                }
            }
        }

        int distance = 0;
        while(!queue.isEmpty()){
            int size = queue.size();
            distance++;
            for(int i =0; i < size; i++){
                int[] point = queue.poll();

                for(int[] dir:directions){
                    int x = point[0] + dir[0];
                    int y = point[1] + dir[1];

                    if(x<0 || x >=grid.length || y<0 || y >= grid[0].length){
                        continue;
                    }
                    if(grid[x][y] != 2147483647 || grid[x][y] == -1){
                        continue;
                    }
                    grid[x][y] = distance; 
                    queue.offer(new int [] {x, y});


                }
                
            }

            
        }
        
    }
}
