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
    // Builds the BST from preorder values inside one range.
    private TreeNode build(int[] preorder, int start, int end) {
        // No values are left in this range, so no subtree exists.
        if (start > end) {
            return null;
        }
 
        // The first value of this range is the subtree root.
        TreeNode root = new TreeNode(preorder[start]);
 
        // Defines the search space for the first greater value.
        int left = start + 1;
        int right = end + 1;
 
        while (left < right) {
            int mid = left + (right - left) / 2;
 
            // A greater middle value may be the first right-subtree value.
            if (preorder[mid] > root.val) {
                right = mid;
            }
            // A smaller middle value still belongs to the left subtree.
            else {
                left = mid + 1;
            }
        }
 
        // Marks where the right subtree begins.
        int splitIndex = left;
 
        root.left = build(preorder, start + 1, splitIndex - 1);
        root.right = build(preorder, splitIndex, end);
 
        return root;
    }
 
    // Prints inorder traversal of the constructed BST.
    private void printInorder(TreeNode root) {
        // Empty subtree has nothing to print.
        if (root == null) {
            return;
        }
 
        printInorder(root.left);
        System.out.print(root.val + " ");
        printInorder(root.right);
    }
 
    /*
    Builds a BST by using binary search
    to split each preorder range.
    */
    public TreeNode bstFromPreorder(int[] preorder) {
        return build(preorder, 0, preorder.length - 1);
    }
 
    // Prints inorder traversal of the constructed BST.
    public void printTree(TreeNode root) {
        printInorder(root);
    }
}