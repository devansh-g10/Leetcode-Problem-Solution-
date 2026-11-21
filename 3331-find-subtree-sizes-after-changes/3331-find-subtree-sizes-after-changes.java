class Solution {
    public int[] findSubtreeSizes(int[] parent, String s) {
        int n = parent.length;
        List<Integer>[] children = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            children[i] = new ArrayList<>();
        }
        for (int i = 1; i < n; i++) {
            children[parent[i]].add(i);
        }

        int[] last = new int[26];
        Arrays.fill(last, -1);
        int[] saved = new int[n];
        int[] size = new int[n];
        Arrays.fill(size, 1);

        int[] stack = new int[2 * n];
        int top = 0;
        stack[top++] = 0;

        while (top > 0) {
            int x = stack[--top];

            if (x >= 0) {
                int c = s.charAt(x) - 'a';
                saved[x] = last[c];
                last[c] = x;
                stack[top++] = ~x;
                for (int ch : children[x]) {
                    stack[top++] = ch;
                }
            } else {
                x = ~x;
                int c = s.charAt(x) - 'a';
                last[c] = saved[x];
                if (x != 0) {
                    int newParent = (saved[x] != -1) ? saved[x] : parent[x];
                    size[newParent] += size[x];
                }
            }
        }
        return size;
    }
}