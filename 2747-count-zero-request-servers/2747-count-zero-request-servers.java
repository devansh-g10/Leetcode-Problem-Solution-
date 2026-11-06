class Solution {
    public int[] countServers(int n, int[][] logs, int x, int[] queries) {
        int qLen = queries.length;
        int[][] sortedQueries = new int[qLen][2];
        for (int i = 0; i < qLen; i++) {
            sortedQueries[i][0] = queries[i];
            sortedQueries[i][1] = i;
        }
        
        Arrays.sort(sortedQueries, Comparator.comparingInt(a -> a[0]));
        Arrays.sort(logs, Comparator.comparingInt(a -> a[1]));
        
        int[] ans = new int[qLen];
        int[] serverCount = new int[n + 1];
        int activeServers = 0;
        int left = 0, right = 0;
        int logsLen = logs.length;
        
        for (int i = 0; i < qLen; i++) {
            int qTime = sortedQueries[i][0];
            int origIdx = sortedQueries[i][1];
            int windowStart = qTime - x;
            
            while (right < logsLen && logs[right][1] <= qTime) {
                int sId = logs[right][0];
                if (serverCount[sId] == 0) {
                    activeServers++;
                }
                serverCount[sId]++;
                right++;
            }
            
            while (left < logsLen && logs[left][1] < windowStart) {
                int sId = logs[left][0];
                serverCount[sId]--;
                if (serverCount[sId] == 0) {
                    activeServers--;
                }
                left++;
            }
            
            ans[origIdx] = n - activeServers;
        }
        
        return ans;
    }
}