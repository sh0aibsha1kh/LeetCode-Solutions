class Solution {
    /**
     * Return the longest palindromic substring in the string.
     * 
     * Go through each character in the string and create a "boundary" that
     * continues to expand outwards while the characters at the boundary also match.
     * Keep track of the largest boundary and return that substring. For the case
     * where the length of the string is even, go through the string two characters
     * at a time to find a match and then expand the boundary outward.
     * 
     * Time Complexity: O(n^2)
     */
    public String longestPalindrome(String s) {
        int n = s.length();
        if (n == 0) {
            return "";
        }
        String currentLongestPalindrome = "" + s.charAt(0); // to convert char to String
        for (int i = 0; i < n; i += 1) {
            int boundary = 1;
            while (i - boundary >= 0 && i + boundary < n && s.charAt(i - boundary) == s.charAt(i + boundary)) {
                if (currentLongestPalindrome.length() < 2 * boundary + 1) {
                    currentLongestPalindrome = s.substring(i - boundary, i + boundary + 1);
                }
                boundary += 1;
            }
        }
        for (int i = 0; i < n - 1; i += 1) {
            int boundary = 1;
            int j = i + 1;
            if (s.charAt(i) == s.charAt(j)) {
                if (currentLongestPalindrome.length() < 2) {
                    currentLongestPalindrome = s.substring(i, j + 1);
                }
                while (i - boundary >= 0 && j + boundary < n && s.charAt(i - boundary) == s.charAt(j + boundary)) {
                    if (currentLongestPalindrome.length() < 2 * boundary + 2) {
                        currentLongestPalindrome = s.substring(i - boundary, j + boundary + 1);
                    }
                    boundary += 1;
                }
            }
        }
        return currentLongestPalindrome;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        String test1 = "babad"; // "aba"
        String test2 = "cbbd"; // "bb"
        String test3 = "abcd"; // "a"
        String test4 = "bananas"; // "anana"

        System.out.println(s.longestPalindrome(test1));
        System.out.println(s.longestPalindrome(test2));
        System.out.println(s.longestPalindrome(test3));
        System.out.println(s.longestPalindrome(test4));
    }
}