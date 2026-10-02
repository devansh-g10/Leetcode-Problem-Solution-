class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        backtrack(result, new StringBuilder(), 0, 0, n);
        return result;
    }

    private void backtrack(List<String> result, StringBuilder curr,
                           int open, int close, int n) {

        if (curr.length() == 2 * n) {
            result.add(curr.toString());
            return;
        }

        if (open < n) {
            curr.append('(');
            backtrack(result, curr, open + 1, close, n);
            curr.deleteCharAt(curr.length() - 1);
        }

        if (close < open) {
            curr.append(')');
            backtrack(result, curr, open, close + 1, n);
            curr.deleteCharAt(curr.length() - 1);
        }
    }
}