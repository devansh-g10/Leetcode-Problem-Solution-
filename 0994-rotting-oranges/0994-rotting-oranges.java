class Solution {
    public int orangesRotting(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        Queue<int[]> q = new ArrayDeque<>();
        int fresh = 0;
        for(int i = 0 ; i<rows;i++){
            for(int j = 0;j<cols;j++){
                if(grid[i][j]==2){
                    q.offer(new int[]{i,j});
                }
                else if(grid[i][j] == 1){
                    fresh++;
                }
            }
        }
        if(fresh == 0){
            return 0;
        }
        int minutes = -1;
        while(!q.isEmpty()){
            int size = q.size();
            for(int k = 0 ; k < size;k++){
                int[] curr = q.poll();
                int cr = curr[0];
                int cc = curr[1];
                int dir[][] = {{1,0},{-1,0},{0,1},{0,-1}};

                for(int i = 0;i<dir.length;i++){
                    int nr = cr + dir[i][0];
                    int nc = cc + dir[i][1];

                    if(nr>=0 && nr<rows && nc>=0 && nc<cols && grid[nr][nc] == 1){
                        grid[nr][nc] = 2;
                        fresh--;
                        q.offer(new int[]{nr,nc});

                    }
                }
            }
            minutes++;
        }
        return fresh == 0 ? minutes : -1;
    }
}