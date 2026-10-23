class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
     List<List<Integer>> ans = new LinkedList();
     Queue<List<Integer>> bfs  =new LinkedList();
     bfs.add(Arrays.asList(0));
     int dest = graph.length -1;

     while(!bfs.isEmpty()){
         List<Integer> path = bfs.poll();
         int current = path.get(path.size()-1);
           if(current == dest){
             ans.add(new ArrayList(path));
           }
              for(int node : graph[current]){
                   List<Integer> newPath = new ArrayList(path);
                   newPath.add(node);
                   bfs.add(newPath);
                }
        }
        return ans;

    }
}