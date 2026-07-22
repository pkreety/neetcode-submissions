class Solution {
    public int countComponents(int n, int[][] edges) {
        List<List<Integer>> adjList = new ArrayList<>(); 
        Set<Integer> visited = new HashSet();
        for(int i =0; i < n; i++){
            adjList.add(new ArrayList());
        }
        int count = 0;
        for(int[] edge: edges){
            adjList.get(edge[0]).add(edge[1]);
            adjList.get(edge[1]).add(edge[0]);
        } 

        for(int i =0; i < n; i++){
            if(visited.contains(i)){;
                continue;
            }
            dfs(i, visited, adjList);
            count++;
        }

        return count;

    }


    private void dfs(int node, Set visited, List<List<Integer>> adjList){

        if(visited.contains(node)){
            return;
        }
        
        visited.add(node);
        List<Integer> neighbors = adjList.get(node);
        for(int neighbour: neighbors){
            dfs(neighbour, visited, adjList);
        }

    }
}
