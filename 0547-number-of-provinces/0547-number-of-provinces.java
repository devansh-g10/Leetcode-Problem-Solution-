class Solution {
    public void dfs(int[][] isConnected , int start , boolean[] visited){
        visited[start] = true;
        for (int i = 0;i<isConnected.length;i++){
            if(isConnected[start][i]==1 && !visited[i]){
                dfs(isConnected,i, visited);
            }
        }
    }
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        boolean[] visited = new boolean[n];
        int provinces = 0;
        for(int i = 0;i<n;i++){
            if(!visited[i]){
                provinces++;
                dfs(isConnected , i , visited);
            }
        }  
        return provinces;
    }
}