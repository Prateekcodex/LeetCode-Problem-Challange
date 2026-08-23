import java.util.*;

class Solution {
    public int maxLevelSum(TreeNode root) {

       
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        int level = 1;
        int answer = 1;
        int maxSum = Integer.MIN_VALUE;



        while (!queue.isEmpty()) {

            int size = queue.size();
            int sum = 0;



            for (int i = 0; i < size; i++) {

                TreeNode current = queue.poll();

                sum += current.val;

                if (current.left != null) {
                    queue.offer(current.left);
                }

                if (current.right != null) {
                    queue.offer(current.right);
                }
            }

            if (sum > maxSum) {
                maxSum = sum;
                answer = level;
            }



            level++;
        }

        return answer;
    }
}