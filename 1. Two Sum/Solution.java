import java.util.Map;
import java.util.HashMap;

class Solution {
    /**
     * Loop through the array once while storing the values and indices inside
     * a dictionary to help retrieve the complementary index.
     * 
     * Time complexity: O(n)
     */
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++){
            if (map.get(target - nums[i]) == null) {
                map.put(nums[i], i);
            } else {
                return new int[]{i, map.get(target-nums[i])};
            }
        }
        return new int[]{-1, -1};
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] testNumbers = new int[]{1, 3, 5, 7};
        int[] results1 = s.twoSum(testNumbers, 8);
        int[] results2 = s.twoSum(testNumbers, 10);
        int[] results3 = s.twoSum(testNumbers, 2);
        System.out.println(results1[0] + " " + results1[1]);
        System.out.println(results2[0] + " " + results2[1]);
        System.out.println(results3[0] + " " + results3[1]);
    }
}