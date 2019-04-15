import java.util.List;
import java.util.ArrayList;

class Solution {
    /**
     * Do a depth first search on every digit and once the path length is equal to
     * the length of the input digits, append that path to the combinations array.
     * 
     * Time complexity: O(3^n x 4^m), where n are the digits that have 3
     * corresponding letters and m are the digits that have 4 corresponding letters.
     */
    public List<String> letterCombinations(String digits) {
        String[] map = new String[] { "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };
        List<String> combinations = new ArrayList<>();

        if (digits.length() == 0) {
            return combinations;
        }

        dfs(digits, 0, "", map, combinations);
        return combinations;

    }

    private void dfs(String digits, int index, String path, String[] map, List<String> combinations) {
        if (digits.length() == path.length()) {
            combinations.add(path);
            return;
        }
        for (int i = index; i < digits.length(); i += 1) {
            int digit = digits.charAt(i) - '0'; // to convert character digit to int
            for (char c : map[digit].toCharArray()) {
                dfs(digits, i + 1, path + c, map, combinations);
            }
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.letterCombinations("23"));
    }
}