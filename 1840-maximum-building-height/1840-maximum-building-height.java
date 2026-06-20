import java.util.*;

class Solution {
    public int maxBuilding(int n, int[][] restrictions) {
        // List<int[]> list = new ArrayList<>();

        // list.add(new int[]{1, 0});

        // for (int[] r : restrictions) {
        //     list.add(new int[]{r[0], r[1]});
        // }

        // Collections.sort(list, (a, b) -> a[0] - b[0]);

        // if (list.get(list.size() - 1)[0] != n) {
        //     int lastIdx = list.get(list.size() - 1)[0];
        //     int lastH = list.get(list.size() - 1)[1];
        //     list.add(new int[]{n, lastH + (n - lastIdx)});
        // }

        // int m = list.size();

        // // Forward pass
        // for (int i = 1; i < m; i++) {
        //     int dist = list.get(i)[0] - list.get(i - 1)[0];
        //     list.get(i)[1] = Math.min(
        //         list.get(i)[1],
        //         list.get(i - 1)[1] + dist
        //     );
        // }

        // // Backward pass
        // for (int i = m - 2; i >= 0; i--) {
        //     int dist = list.get(i + 1)[0] - list.get(i)[0];
        //     list.get(i)[1] = Math.min(
        //         list.get(i)[1],
        //         list.get(i + 1)[1] + dist
        //     );
        // }

        // int ans = 0;

        // for (int i = 1; i < m; i++) {
        //     int x1 = list.get(i - 1)[0];
        //     int h1 = list.get(i - 1)[1];

        //     int x2 = list.get(i)[0];
        //     int h2 = list.get(i)[1];

        //     int dist = x2 - x1;

        //     ans = Math.max(
        //         ans,
        //         (h1 + h2 + dist) / 2
        //     );
        // }

        // return ans;


        // Second Method 
        int m = restrictions.length;
        
        // Base case: if there are no restrictions, the building height can grow up to n - 1
        if (m == 0) {
            return n - 1;
        }

        // Sort restrictions by building ID inline
        // Sorting primitives inside 2D array layouts keeps them cache-friendly
        Arrays.sort(restrictions, (a, b) -> Integer.compare(a[0], b[0]));

        // Step 1: Left-to-Right Pass
        // First restriction compared against building 1 (which starts at height 0)
        restrictions[0][1] = Math.min(restrictions[0][1], restrictions[0][0] - 1);
        for (int i = 1; i < m; i++) {
            int maxAllowedFromLeft = restrictions[i - 1][1] + (restrictions[i][0] - restrictions[i - 1][0]);
            if (restrictions[i][1] > maxAllowedFromLeft) {
                restrictions[i][1] = maxAllowedFromLeft;
            }
        }

        // Step 2: Right-to-Left Pass
        for (int i = m - 2; i >= 0; i--) {
            int maxAllowedFromRight = restrictions[i + 1][1] + (restrictions[i + 1][0] - restrictions[i][0]);
            if (restrictions[i][1] > maxAllowedFromRight) {
                restrictions[i][1] = maxAllowedFromRight;
            }
        }

        int maxTallestBuilding = 0;

        // Step 3: Calculate peak heights between consecutive restrictions
        // Handle interval from building 1 up to the first restricted building
        maxTallestBuilding = Math.max(maxTallestBuilding, (0 + restrictions[0][1] + restrictions[0][0] - 1) / 2);

        for (int i = 1; i < m; i++) {
            int posA = restrictions[i - 1][0];
            int hA = restrictions[i - 1][1];
            int posB = restrictions[i][0];
            int hB = restrictions[i][1];

            // Use the absolute midpoint intersection formula to calculate peak height
            int currentPeak = (hA + hB + (posB - posA)) / 2;
            if (currentPeak > maxTallestBuilding) {
                maxTallestBuilding = currentPeak;
            }
        }

        // Handle the boundary interval from the final restricted building up to building n
        int lastPos = restrictions[m - 1][0];
        int lastH = restrictions[m - 1][1];
        int finalEndPeak = lastH + (n - lastPos);
        if (finalEndPeak > maxTallestBuilding) {
            maxTallestBuilding = finalEndPeak;
        }

        return maxTallestBuilding;
    }
}