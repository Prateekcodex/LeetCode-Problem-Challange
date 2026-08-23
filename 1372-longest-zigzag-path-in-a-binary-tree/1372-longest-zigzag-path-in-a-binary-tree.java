class Solution {

    private int answer = 0;

    public int longestZigZag(TreeNode root) {

        dfs(root, true, 0);
        dfs(root, false, 0);

        return answer;
    }

    private void dfs(TreeNode node, boolean goLeft, int length) {

        if (node == null) {
            return;
        }

        answer = Math.max(answer, length);

        if (goLeft) {

            dfs(node.left, false, length + 1);

            dfs(node.right, true, 1);

        } else {

            dfs(node.right, true, length + 1);

            dfs(node.left, false, 1);
        }
    }
}