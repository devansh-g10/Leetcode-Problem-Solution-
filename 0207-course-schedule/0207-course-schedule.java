class Solution {
    public boolean canFinish(int n, int[][] p) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        int[] state = new int[n];
        for(int i = 0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int i = 0;i<p.length;i++){
            int u = p[i][1];
            int v = p[i][0];
            adj.get(u).add(v);
        }
        for(int i =0; i<n; i++){
            if(state[i]==0){
                if(hasCycle(i,state,adj)){
                    return false;
                }
            }
        }
        return true;
    }
    private boolean hasCycle(int node, int[] state, ArrayList<ArrayList<Integer>> adj) {
        state[node] = 1; 
        
        for (int neighbor : adj.get(node)) {
            if (state[neighbor] == 1) {
                return true;
            }
            if (state[neighbor] == 0) {
                if (hasCycle(neighbor, state, adj)) {
                    return true;
                }
            }
        }
        
        state[node] = 2;
        return false;
    }
}