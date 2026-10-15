class DSU{
    int parent[];
    int rank[];
    DSU(int V){
        parent = new int[V];
        rank = new int[V];
        for(int i = 0;i<V;i++){
            parent[i] = i;
        }
    }
    int find(int x){
        if(parent[x]!=x){
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    boolean union(int a , int b){
        int rootA = find(a);
        int rootB = find(b);
        if(rootA == rootB){
            return false;
        }
        if(rank[rootA] < rank[rootB]){
            parent[rootA] = rootB;
        }
        else if(rank[rootB] < rank[rootA]){
            parent[rootB] = rootA;
        }
        else{
            parent[rootA] = rootB;
            rank[rootB]++;
        }
        return true;
    }
}
class Solution {
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        DSU dsu = new DSU(n);
        
        // Total number of edges = n * (n - 1) / 2
        int totalEdges = (n * (n - 1)) / 2;
        int[][] edges = new int[totalEdges][3];
        
        int idx = 0;
        for(int i = 0; i < n; i++) {
            for(int j = i + 1; j < n; j++) {
                int cost = Math.abs(points[i][0] - points[j][0]) + Math.abs(points[i][1] - points[j][1]);
                edges[idx][0] = i;
                edges[idx][1] = j;
                edges[idx][2] = cost;
                idx++;
            }
        }
        
        // Sort edges based on cost/weight (Column 2)
        java.util.Arrays.sort(edges, (a, b) -> Integer.compare(a[2], b[2]));
        
        int minCost = 0;
        int edgesCount = 0;
        
        for(int i = 0; i < totalEdges; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            int cost = edges[i][2];
            
            if(dsu.union(u, v)) {
                minCost += cost;
                edgesCount++;
                if(edgesCount == n - 1) {
                    break;
                }
            }
        }
        
        return minCost;
        
    }
}