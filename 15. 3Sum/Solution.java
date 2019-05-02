import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    /**
     * Return a list of triplets (numbers that sum to zero).
     * 
     * First sort the array and then loop through all triplets by maintaining three
     * pointers (while excluding duplicate values) and if the sum of the three
     * values equals 0, append it to the list of triplets.
     * 
     * Time complexity: O(n^2)
     */
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> triplets = new ArrayList<>();
        int length = nums.length;

        for (int i = 0; i < length - 2; i += 1) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int j = i + 1, k = length - 1;

            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if (sum > 0) { // k is too big, reduce it
                    k -= 1;
                } else if (sum < 0) { // j is too small, increase it
                    j += 1;
                } else {
                    List<Integer> triplet = new ArrayList<>();
                    triplet.add(nums[i]);
                    triplet.add(nums[j]);
                    triplet.add(nums[k]);
                    triplets.add(triplet);
                    k -= 1;
                    j += 1;
                    while (j < k && nums[j] == nums[j - 1])
                        j += 1;
                    while (j < k && nums[k] == nums[k + 1])
                        k -= 1;
                }
            }
        }
        return triplets;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] testNumbers = new int[] { -1, 0, 1, 2, -1, -4 };
        int[] testNumbers2 = new int[] { 1, -1, -1, 0 };
        System.out.println(s.threeSum(testNumbers));
        System.out.println(s.threeSum(testNumbers2));
    }
}