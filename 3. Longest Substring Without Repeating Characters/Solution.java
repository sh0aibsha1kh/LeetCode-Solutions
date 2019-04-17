import java.util.Map;
import java.util.HashMap;

class Solution {
    /**
     * Returns the length of the longest substring without repeating characters in a
     * given string.
     * 
     * Loop through the string once and keep track of the longest substring without
     * repeating characters as well as its starting index. For each iteration, if
     * the character has been seen AND the starting index is less than or equal to
     * the index of the current character, move the starting index of our substring
     * over by one.
     * 
     * Time complexity: O(n)
     */
    public int longestSubstringWithoutRepeatingCharacters(String s) {
        int longest = 0;
        int startingIndex = 0;
        Map<Character, Integer> seen = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (seen.containsKey(s.charAt(i)) && startingIndex <= seen.get(s.charAt(i))) {
                startingIndex = seen.get(s.charAt(i)) + 1;
            } else {
                longest = Math.max(longest, i - startingIndex + 1);
            }
            seen.put(s.charAt(i), i);
        }
        return longest;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.longestSubstringWithoutRepeatingCharacters("abcabcbb")); // -> 3
        System.out.println(s.longestSubstringWithoutRepeatingCharacters("bbbbb")); // -> 1
        System.out.println(s.longestSubstringWithoutRepeatingCharacters("pwwkew")); // -> 3
        System.out.println(s.longestSubstringWithoutRepeatingCharacters("dvdf")); // -> 3
    }
}