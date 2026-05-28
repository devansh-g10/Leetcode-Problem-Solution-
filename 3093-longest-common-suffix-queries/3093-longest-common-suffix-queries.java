class TrieNode {
    TrieNode[] children = new TrieNode[26];

    int index = Integer.MAX_VALUE;
    int length = Integer.MAX_VALUE;
}

class Solution {

    TrieNode root = new TrieNode();

    private void insert(String word, int idx) {

        TrieNode node = root;

        // update root
        update(node, word.length(), idx);

        for (int i = word.length() - 1; i >= 0; i--) {

            int ch = word.charAt(i) - 'a';

            if (node.children[ch] == null) {
                node.children[ch] = new TrieNode();
            }

            node = node.children[ch];

            update(node, word.length(), idx);
        }
    }

    private void update(TrieNode node, int len, int idx) {

        if (len < node.length) {
            node.length = len;
            node.index = idx;
        } 
        else if (len == node.length && idx < node.index) {
            node.index = idx;
        }
    }

    private int search(String word) {

        TrieNode node = root;

        for (int i = word.length() - 1; i >= 0; i--) {

            int ch = word.charAt(i) - 'a';

            if (node.children[ch] == null) {
                break;
            }

            node = node.children[ch];
        }

        return node.index;
    }

    public int[] stringIndices(String[] wordsContainer, String[] wordsQuery) {

        for (int i = 0; i < wordsContainer.length; i++) {
            insert(wordsContainer[i], i);
        }

        int[] ans = new int[wordsQuery.length];

        for (int i = 0; i < wordsQuery.length; i++) {
            ans[i] = search(wordsQuery[i]);
        }

        return ans;
    }
}