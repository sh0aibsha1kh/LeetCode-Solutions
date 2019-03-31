import java.util.Arrays;

class Solution {
    /**
     * Returns an array of the largest integers in each sliding window in the
     * original array.
     * 
     * Create a separate array of size n - k + 1, and for each iteration of the
     * sliding window, insert the maximum value into this array and return it at the
     * end.
     * 
     * Time complexity: O(kn)
     */
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        if (n == 0)
            return new int[0];
        int[] maxSlidingWindow = new int[n - k + 1];
        for (int i = 0; i < n - k + 1; i += 1) {
            int[] window = Arrays.copyOfRange(nums, i, i + k);
            int max = window[0];
            for (int j : window) {
                max = Math.max(max, j);
            }
            maxSlidingWindow[i] = max;
        }
        return maxSlidingWindow;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] test1 = new int[] { 1, 3, -1, -3, 5, 3, 6, 7 };
        System.out.println(s.maxSlidingWindow(test1, 3)[0]);
        System.out.println(s.maxSlidingWindow(test1, 3)[1]);
        System.out.println(s.maxSlidingWindow(test1, 3)[2]);
        System.out.println(s.maxSlidingWindow(test1, 3)[3]);
        System.out.println(s.maxSlidingWindow(test1, 3)[4]);
        System.out.println(s.maxSlidingWindow(test1, 3)[5]);
    }
}