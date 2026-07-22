class Solution {
    public int orangesRotting(int[][] grid) {

        int[][] directions = {{0,1},{1,0},{0, -1},{-1,0}};
        Queue<int[]>  queue = new LinkedList();
        int noOfFreshFruit = 0;

        for(int i =0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j]== 2){
                    queue.offer(new int[]{i, j});
                }

                if(grid[i][j]== 1){
                    noOfFreshFruit++;
                }

            }
        }

        if (noOfFreshFruit == 0) return 0;

        int distance = 0;
        while(!queue.isEmpty()){
            int size = queue.size();
            if (noOfFreshFruit == 0) break;
            distance++;
            for(int i =0;i < size;i++){
                int[] cell = queue.poll();
                for(int[] dir:directions) {
                    int x = cell[0] + dir[0];
                    int y = cell[1] + dir[1];

                    if(x < 0 || y < 0 || x >=grid.length || y >= grid[0].length || grid[x][y] == 2 || grid[x][y]==0){
                        continue;
                    }
                    if(grid[x][y]== 1){
                        grid[x][y] = 2; 
                        noOfFreshFruit--;
                        queue.offer(new int[]{x, y});
                    }

                }


            }
           


        }
     return noOfFreshFruit==0?distance : -1;
        
    }
}
