class Solution {
    /**
     * Rotates the matrix 90 degrees to the right.
     * 
     * First flip the matrix vertically, then transpose it.
     * 
     * Time complexity: O(n^2)
     */
    public void rotate(int[][] matrix) {
        for (int i = 0; i < matrix.length / 2; i += 1) {
            for (int j = 0; j < matrix[0].length; j += 1) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[matrix.length - 1 - i][j];
                matrix[matrix.length - 1 - i][j] = temp;
            }
        }
        for (int i = 0; i < matrix.length; i += 1) {
            for (int j = i; j < matrix[0].length; j += 1) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }
}