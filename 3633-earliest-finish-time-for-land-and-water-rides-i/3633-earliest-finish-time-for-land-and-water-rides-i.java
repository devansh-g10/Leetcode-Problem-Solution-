class Solution {

    private int calculate(int[] start1, int[] duration1,
                          int[] start2, int[] duration2) {

        // Earliest finishing time from first ride category
        int firstFinish = Integer.MAX_VALUE;

        for (int i = 0; i < start1.length; i++) {
            firstFinish = Math.min(firstFinish,
                                   start1[i] + duration1[i]);
        }

        // Try all rides from second category
        int ans = Integer.MAX_VALUE;

        for (int i = 0; i < start2.length; i++) {

            int startTime = Math.max(firstFinish, start2[i]);

            int finishTime = startTime + duration2[i];

            ans = Math.min(ans, finishTime);
        }

        return ans;
    }

    public int earliestFinishTime(int[] landStartTime,
                                  int[] landDuration,
                                  int[] waterStartTime,
                                  int[] waterDuration) {

        // Option 1: Land -> Water
        int option1 = calculate(
                landStartTime, landDuration,
                waterStartTime, waterDuration
        );

        // Option 2: Water -> Land
        int option2 = calculate(
                waterStartTime, waterDuration,
                landStartTime, landDuration
        );

        return Math.min(option1, option2);
    }
}