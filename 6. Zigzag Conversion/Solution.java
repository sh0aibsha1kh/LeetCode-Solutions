import java.util.Map;
import java.util.HashMap;

class Solution {
    /**
     * Return a zigzagged version of the given string.
     * 
     * Create a list of size equal to the number of rows. Iterate through the
     * string and append each character to the appropriate index in the list.
     * Essentially going back and forth between the indices (zigzag).
     * 
     * Time complexity: O(n)
     */
    public String zigzag_conversion(String s, int numRows) {
        if (numRows == 1 || numRows >= s.length()){
            return s;
        }
        
        String[] zigzag = new String[numRows];

        for(int i = 0; i < zigzag.length; i += 1){
            zigzag[i] = "";
        }

        int row = 0;
        int step = 1;
        
        for (int i = 0; i < s.length(); i += 1){
            zigzag[row] += s.charAt(i);
            if (row == 0){
                step = 1;
            } else if (row == numRows - 1){
                step = -1;
            }
            row += step;
        }

        String converted = "";
        for (int i = 0; i < zigzag.length; i+=1){
            converted += zigzag[i];
        }
        return converted;

    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.zigzag_conversion("PAYPALISHIRING", 3)); // -> "PAHNAPLSIIGYIR"
        System.out.println(s.zigzag_conversion("PAYPALISHIRING", 4)); // -> "PINALSIGYAHRPI"
    }
}