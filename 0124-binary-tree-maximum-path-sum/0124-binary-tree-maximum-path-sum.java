class Solution {

    int ans = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        dfs(root);
        return ans;
    }

    private int dfs(TreeNode root) {

        if (root == null) {
            return 0;
        }

        int left = Math.max(0, dfs(root.left));
        int right = Math.max(0, dfs(root.right));

        int currentPath = root.val + left + right;

        ans = Math.max(ans, currentPath);

        return root.val + Math.max(left, right);
    }
}