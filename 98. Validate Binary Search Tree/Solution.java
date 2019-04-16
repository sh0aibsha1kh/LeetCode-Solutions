class Solution {
    /**
     * Returns true if the given tree is a valid binary search tree.
     * 
     * Do an iterative in-order traversal of a binary tree while keeping track of
     * the previously seen node in the stack. If at any point the current node's
     * valuse is less than the previous node's value, return false.
     * 
     * Time complexity: O(n)
     */
    public boolean isValidBST(TreeNode root) {
        if (root == null)
            return true;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode previous = null;
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (previous != null && root.val <= previous.val)
                return false;
            previous = root;
            root = root.right;
        }
        return true;
    }
}