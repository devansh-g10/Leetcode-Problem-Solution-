class Solution {
    int[] parent;
    int[] rank;

    int find(int x){
        if(parent[x] != x){
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
        parent[rootA] = rootB;
        rank[rootB]++;
        return true;
    }
    public int makeConnected(int n, int[][] connections) {
        if(connections.length < n-1){
            return -1;
        }

        parent = new int[n];
        rank = new int[n];

        for(int i = 0 ; i<n;i++){
            parent[i] = i;
        }
        int components = n;
        for(int[] edge : connections){
            if(union(edge[0], edge[1])){
                components--;
            }
        }
        return components-1;
    }
}