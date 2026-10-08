class DSU{
    int parent[];
    int rank[];
    DSU(int v){
        rank = new int[v];
        parent = new int[v];
        for(int i = 0 ; i<v ; i++){
            parent[i] = i;
        }
    }
    public int find(int node){
        if(parent[node] != node){
            parent[node] = find(parent[node]);
        }
        return parent[node];
    }

    boolean union(int a , int b){
        int rootA = find(a);
        int rootB = find(b);
        if(rootA == rootB){
            return false;
        }
        parent[rootB] = rootA;
        return true;

    }

}
class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        DSU dsu = new DSU(n+1);
        for(int[] edge : edges){
            int u = edge[0];
            int v = edge[1];
            if(!dsu.union(u,v)){
                return edge;
            }
        }
        return new int[0];
    }
}