/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {

    int count = 0;
    int answer = 0;

    public int kthSmallest(TreeNode root, int k) {
        find(root, k);
        return answer;
    }

    private void find(TreeNode root, int k) {

        // Base case
        if (root == null || count >= k) {
            return;
        }

        // LEFT
        find(root.left, k);

        // ROOT
        count++;

        if (count == k) {
            answer = root.val;
            return;
        }

        // RIGHT
        find(root.right, k);
    }
}