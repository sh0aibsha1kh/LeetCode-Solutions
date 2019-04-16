class Solution {
    /**
     * Returns the maximum profit that can be made by buying low and selling high.
     * 
     * We will do this in a single pass by keeping track of the minimum and maximum
     * price. As we traverse through the array, keep updating the minimum price with
     * smaller values. If at any point, the current value minus the minimum value
     * exceeds our maximum profit, update the maximum profit.
     * 
     * Time complexity: O(n)
     */
    public int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;

        for (int i = 0; i < prices.length; i += 1) {
            if (prices[i] < minPrice) {
                minPrice = prices[i];
            } else if (prices[i] - minPrice > maxProfit) {
                maxProfit = prices[i] - minPrice;
            }
        }
        return maxProfit;
    }
}