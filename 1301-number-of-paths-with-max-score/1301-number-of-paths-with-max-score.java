class Solution {
    static final int MOD = 1_000_000_007;

    public int[] pathsWithMaxScore(List<String> board) {
        int n = board.size();

        int[][] score = new int[n][n];
        long[][] ways = new long[n][n];

        for (int[] row : score) {
            Arrays.fill(row, -1);
        }

        score[n - 1][n - 1] = 0;
        ways[n - 1][n - 1] = 1;

        for (int i = n - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {

                if (board.get(i).charAt(j) == 'X' ||
                    (i == n - 1 && j == n - 1)) {
                    continue;
                }

                int best = -1;
                long count = 0;

                // Down
                if (i + 1 < n && score[i + 1][j] != -1) {
                    if (score[i + 1][j] > best) {
                        best = score[i + 1][j];
                        count = ways[i + 1][j];
                    } else if (score[i + 1][j] == best) {
                        count = (count + ways[i + 1][j]) % MOD;
                    }
                }

                // Right
                if (j + 1 < n && score[i][j + 1] != -1) {
                    if (score[i][j + 1] > best) {
                        best = score[i][j + 1];
                        count = ways[i][j + 1];
                    } else if (score[i][j + 1] == best) {
                        count = (count + ways[i][j + 1]) % MOD;
                    }
                }

                // Diagonal
                if (i + 1 < n && j + 1 < n &&
                    score[i + 1][j + 1] != -1) {

                    if (score[i + 1][j + 1] > best) {
                        best = score[i + 1][j + 1];
                        count = ways[i + 1][j + 1];
                    } else if (score[i + 1][j + 1] == best) {
                        count = (count + ways[i + 1][j + 1]) % MOD;
                    }
                }

                if (best == -1) continue;

                int value = 0;
                char ch = board.get(i).charAt(j);

                if (Character.isDigit(ch)) {
                    value = ch - '0';
                }

                score[i][j] = best + value;
                ways[i][j] = count;
            }
        }

        if (score[0][0] == -1) {
            return new int[]{0, 0};
        }

        return new int[]{
            score[0][0],
            (int) ways[0][0]
        };
    }
}