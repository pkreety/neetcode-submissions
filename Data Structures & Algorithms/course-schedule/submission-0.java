class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
       
        Map<Integer, List<Integer>> adjList = new HashMap();
        int[] inDegree = new int[numCourses];
        if(numCourses ==0){
            return true;
        }

        Queue<Integer> queue = new LinkedList(); 
        for(int[] pre: prerequisites){
            inDegree[pre[0]]++;
            adjList.putIfAbsent(pre[1], new ArrayList());
            adjList.get(pre[1]).add(pre[0]);
        }

        for(int i =0; i < numCourses;i++){
            if(inDegree[i]==0){
                queue.offer(i);
            }
        }
        while(!queue.isEmpty()){
            int node = queue.poll();
            List<Integer> dependents = adjList.get(node);
            if (dependents != null) {
                for(int neighbor: dependents){
                    inDegree[neighbor]--;
                    if(inDegree[neighbor]==0){
                        queue.offer(neighbor);
                    }
                }
            }
        }

        for(int i =0; i < numCourses;i++){
            if(inDegree[i]!= 0){
                return false;
            }
        }

        return true;
        
        
    }
}
