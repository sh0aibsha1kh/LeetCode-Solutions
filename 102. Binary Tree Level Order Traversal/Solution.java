class Solution {
    /**
     * Returns a list of nodes in a binary tree according to their depth.
     * 
     * This is essentially a BFS. For each level, append the nodes to their own list
     * while adding its children to the queue.
     * 
     * Time complexity: O(n)
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> levels = new ArrayList<>();
        if (root == null)
            return levels;
        queue.offer(root);
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            List<Integer> order = new ArrayList<>();
            for (int i = 0; i < levelSize; i++) {
                if (queue.peek().left != null)
                    queue.offer(queue.peek().left);
                if (queue.peek().right != null)
                    queue.offer(queue.peek().right);
                order.add(queue.poll().val);
            }
            levels.add(order);
        }
        return levels;
    }
}