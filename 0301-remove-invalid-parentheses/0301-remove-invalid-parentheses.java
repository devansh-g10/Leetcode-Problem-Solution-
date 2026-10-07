class Solution {
    public List<String> removeInvalidParentheses(String s) {
        int n = s.length();
        HashSet<String> valid = dfs(s, 0, 0, new HashSet[n + 1][n + 1]);

        int maxLen = 0;
        for (String str : valid) {
            maxLen = Math.max(maxLen, str.length());
        }

        List<String> ans = new ArrayList<>();
        for (String str : valid) {
            if (str.length() == maxLen) {
                ans.add(str);
            }
        }

        return ans;
    }

    private HashSet<String> dfs(String s, int i, int open, HashSet<String>[][] memo) {
        HashSet<String> ans = new HashSet<>();

        if (open < 0) return ans;
        if (memo[i][open] != null) return memo[i][open];

        if (i == s.length()) {
            if (open == 0) {
                ans.add("");
            }
            return memo[i][open] = ans;
        }

        char c = s.charAt(i);

        if (c == '(' || c == ')') {
            ans.addAll(dfs(s, i + 1, open, memo));
        }

        int nextOpen = open;

        if (c == '(') nextOpen++;
        else if (c == ')') nextOpen--;

        for (String suffix : dfs(s, i + 1, nextOpen, memo)) {
            ans.add(c + suffix);
        }

        return memo[i][open] = ans;
    }
}