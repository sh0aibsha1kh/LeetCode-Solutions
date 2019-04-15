class Solution {
    /**
     * Returns the total amount of water that can be trapped.
     * 
     * Iterate from left to right while keeping track of the largest tower. Iterate
     * from right to left while keeping the largest tower. Then, the water that can
     * be trapped will be the minimum of these two value at the same index,
     * subtracted by what the actual height is at that index.
     * 
     * Time complexity: O(n)
     */
    public int trap(int[] height) {
        int totalWater = 0;
        int length = height.length;
        if (length == 0) {
            return 0;
        }
        int[] leftToRight = new int[length];
        int[] rightToLeft = new int[length];
        leftToRight[0] = height[0];
        for (int i = 1; i < length; i += 1) {
            leftToRight[i] = Math.max(height[i], leftToRight[i - 1]);
        }
        rightToLeft[length - 1] = height[length - 1];
        for (int i = length - 2; i >= 0; i -= 1) {
            rightToLeft[i] = Math.max(height[i], rightToLeft[i + 1]);
        }
        for (int i = 1; i < length - 1; i += 1) {
            totalWater += Math.min(leftToRight[i], rightToLeft[i]) - height[i];
        }
        return totalWater;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] test1 = new int[] { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };
        System.out.println(s.trap(test1)); // 6
    }
}