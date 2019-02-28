class Solution:
    """
    Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.

    Example 1:

    Input: "babad"
    Output: "bab"
    Note: "aba" is also a valid answer.

    Example 2:

    Input: "cbbd"
    Output: "bb"
    """

    def naive_longest_palindromic_substring(self, s):
        """
        Have a nested for loop to go through all possible substrings. Then use
        another loop to verify that the substring is a palindrome,
        Time Complexity: O(n^3)
        """
        longest_palindrome = ""
        n = len(s)

        for i in range(n):
            for j in range(n):
                if i <= j:
                    substring_length = len(s[i:j+1])
                    if substring_length == 1 and \
                        len(s[i:j+1]) > len(longest_palindrome):
                        longest_palindrome = s[i:j+1]
                        continue
                    k = 0
                    is_palindrome = True
                    while k < substring_length // 2:
                        if s[i+k] != s[j-k]:
                            is_palindrome = False
                            break
                        k += 1
                    if is_palindrome and substring_length > len(longest_palindrome):
                        longest_palindrome = s[i:j+1]
                        continue
        return longest_palindrome


if __name__ == "__main__":
    s = Solution()

    print(s.naive_longest_palindromic_substring("babad"))  # -> "bab"
    print(s.naive_longest_palindromic_substring("cbbd"))  # -> "bb"
    print(s.naive_longest_palindromic_substring("abcd"))  # -> "a"
    print(s.naive_longest_palindromic_substring("bananas"))  # -> "anana"
