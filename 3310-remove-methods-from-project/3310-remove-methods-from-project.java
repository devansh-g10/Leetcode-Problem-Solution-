class Solution {
    boolean outsideConnection = false;
    int[] mark;

    public List<Integer> remainingMethods(int n, int k, int[][] edges) {
        List<Integer> res = new ArrayList<>();
        HashMap<Integer, ArrayList<Integer>> graph = new HashMap<>();
        mark = new int[n];

        for(int[] edge : edges){
            graph.computeIfAbsent(edge[0], x -> new ArrayList<>()).add(edge[1]);
        }

        bfs(1, graph, k);

        for(int i = 0; i < n; i++){
            if(i == k || mark[i] == 1) continue;
            bfs(2, graph, i);
        }

        for(int i = 0; i < n; i++){
            if(!outsideConnection && mark[i] == 1) continue;
            res.add(i);
        }

        return res;
    }

    private void bfs(int color, HashMap<Integer, ArrayList<Integer>> graph, int src){
        Queue<Integer> q = new LinkedList<>();
        q.offer(src);
        mark[src] = color;

        while(!q.isEmpty()){
            int node = q.poll();

            if(!graph.containsKey(node)) continue;

            for(int nxt : graph.get(node)){
                if(mark[nxt] == 1 && color == 2){
                    outsideConnection = true;
                    return;
                }

                if(mark[nxt] != color){
                    mark[nxt] = color;
                    q.offer(nxt);
                }
            }
        }
    }
}