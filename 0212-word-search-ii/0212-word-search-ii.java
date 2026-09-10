class Solution {

    class TrieNode {
        TrieNode[] children = new TrieNode[26];
        String word;
    }

    private final TrieNode root = new TrieNode();
    private final List<String> result = new ArrayList<>();

    public List<String> findWords(char[][] board, String[] words) {

        // (Build Trie)
        for (String word : words) {
            insert(word);
        }

        // (Start DFS from every cell)
        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board[0].length; c++) {
                dfs(board, r, c, root);
            }
        }

        return result;
    }

    private void insert(String word) {

        TrieNode node = root;

        for (char ch : word.toCharArray()) {
            int index = ch - 'a';

            if (node.children[index] == null) {
                node.children[index] = new TrieNode();
            }

            node = node.children[index];
        }

        // (Store complete word at its ending node)
        node.word = word;
    }

    private void dfs(char[][] board, int r, int c, TrieNode node) {

        // (Boundary check)
        if (r < 0 || r >= board.length ||
            c < 0 || c >= board[0].length) {
            return;
        }

        char ch = board[r][c];

        if (ch == '#') {
            return;
        }

        TrieNode next = node.children[ch - 'a'];

        if (next == null) {
            return;
        }

        if (next.word != null) {
            result.add(next.word);
            next.word = null;
        }

        board[r][c] = '#';

        // Explore 4 directions
        dfs(board, r + 1, c, next); // down
        dfs(board, r - 1, c, next); // up
        dfs(board, r, c + 1, next); // right
        dfs(board, r, c - 1, next); // left

        // Backtrack
        board[r][c] = ch;
    }
}