class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n = rooms.size();
        boolean[] visited = new boolean[n];
        dfs(rooms,0,visited);
        for(int i = 0;i<n;i++){
            if(!visited[i]){
                return false;
            }
        }
        return true;
    }
    public static void dfs(List<List<Integer>> rooms, int start , boolean[] visited){
        visited[start] = true;
        for(int nbr : rooms.get(start)){
            if(!visited[nbr]){
                dfs(rooms,nbr,visited);
            }
        }
    }
}