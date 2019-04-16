class Solution {
    /**
     * Returns a list of all the subsets of a given set.
     * 
     * At every index, we have to choose whether to select an item or not select an
     * item. This is where the backtracking happens.
     * 
     * Time complexity: O(2 ^ n)
     */
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> powerSet = new ArrayList<>();
        backtrack(nums, powerSet, new ArrayList<>(), 0);
        return powerSet;
    }

    private void backtrack(int[] nums, List<List<Integer>> powerSet, List<Integer> subset, int start) {
        powerSet.add(new ArrayList<>(subset));
        for (int i = start; i < nums.length; i += 1) {
            subset.add(nums[i]);
            backtrack(nums, powerSet, subset, i + 1);
            subset.remove(subset.size() - 1);
        }
    }
}