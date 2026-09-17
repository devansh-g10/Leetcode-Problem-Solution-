class Solution {
    public boolean dfs(int s , int[] state , ArrayList<ArrayList<Integer>> adj, Stack st){
        state[s] = 1;
        for (int neighbor : adj.get(s)) {
            if (state[neighbor] == 1) {
                return true;
            }
            if (state[neighbor] == 0) {
                if (dfs(neighbor, state, adj, st)) {
                    return true;
                }
            }
        }
        state[s] = 2;
        st.push(s);  
        return false;
    }
    public int[] findOrder(int n, int[][] p) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0 ; i<n ; i++){
            adj.add(new ArrayList<>());
        }
        for(int i = 0 ; i < p.length ; i++){
            int u = p[i][1];
            int v = p[i][0];
            adj.get(u).add(v);
        }
        int state[] = new int[n];
        Stack<Integer> st = new Stack<>();
        for(int i =0; i<n; i++){
            if(state[i]==0){
                if(dfs(i,state,adj,st)==true){
                    return new int[0];
                }
            }
        }
        int[] result = new int[n];
        int idx = 0;
        while (!st.isEmpty()) {
            result[idx++] = st.pop();
        }
        
        return result;
    }
}