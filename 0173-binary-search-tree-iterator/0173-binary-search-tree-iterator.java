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
class BSTIterator {
    // Explicit stack to simulate and pause the recursion
    private Stack<TreeNode> st;
    
    // Helper function to push the current node and all its left children
    private void pushAllLeft(TreeNode node) {
        while (node != null) {
            st.push(node);
            node = node.left;
        }
    }
 
    // Constructor initializes the state by loading the leftmost path
    public BSTIterator(TreeNode root) {
        st = new Stack<>();
        pushAllLeft(root);
    }
    
    // Retrieves the next smallest element and updates the stack state
    public int next() {
        // The top of the stack is always the next smallest value
        TreeNode topNode = st.pop();
        
        // If the processed node has a right branch, load its leftmost path
        if (topNode.right != null) {
            pushAllLeft(topNode.right);
        }
        
        return topNode.val;
    }
    
    // Returns true as long as there are pending nodes in the stack
    public boolean hasNext() {
        return !st.isEmpty();
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */