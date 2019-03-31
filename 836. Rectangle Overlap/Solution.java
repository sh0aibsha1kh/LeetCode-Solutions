class Solution {
    /**
     * Returns whether or not the rectangles overlap.
     * 
     * Verify the conditions of the corners of one rectangle being less than the
     * corners of the other rectangle.
     * 
     * Time Complexity: O(1)
     */
    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        return rec1[0] < rec2[2] && rec2[0] < rec1[2] && rec1[1] < rec2[3] && rec2[1] < rec1[3];
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[][] test1 = new int[][] { { 0, 0, 2, 2 }, { 1, 1, 3, 3 } };
        int[][] test2 = new int[][] { { 0, 0, 1, 1 }, { 1, 0, 2, 1 } };
        int[][] test3 = new int[][] { { 1, 1, 3, 3 }, { 0, 0, 2, 2 } };
        System.out.println(s.isRectangleOverlap(test1[0], test1[1])); // true
        System.out.println(s.isRectangleOverlap(test2[0], test2[1])); // false
        System.out.println(s.isRectangleOverlap(test3[0], test3[1])); // true
    }
}
