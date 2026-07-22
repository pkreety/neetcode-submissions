class Solution {
    public boolean validTree(int n, int[][] edges) {
        if (edges.length != n - 1) {
            return false;
        }

        List<List<Integer>> adjList = new ArrayList();
       
        for(int i =0; i < n; i++){      
            adjList.add(new ArrayList());
        }

        for(int i =0; i < edges.length;i++){
            adjList.get(edges[i][0]).add(edges[i][1]);
            adjList.get(edges[i][1]).add(edges[i][0]);
        }

        Set<Integer> visited  = new HashSet();
        if(!dfs(adjList, 0, -1, visited)){
            return false;
        }

        return visited.size() == n;

    }
    public boolean dfs(List<List<Integer>> adjList, int n, int parent, Set<Integer> visited){
        if(visited.contains(n)){
            return false;
        }
        visited.add(n);
        System.out.println("visited "+n);
        List<Integer> neighbours = adjList.get(n);
        for(int node : neighbours){
            if(node == parent) continue;
            if(!dfs(adjList, node, n, visited)){
                return false;
            }
        }
    
        return true;
    }

    }