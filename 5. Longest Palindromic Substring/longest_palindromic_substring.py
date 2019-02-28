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
        longest_palindrome = ""
        n = len(s)

        for i in range(n):
            for j in range(n):
                if i < j:
                    substring_length = j - i
                    if substring_length == 1 and \
                        len(s[i:j]) > len(longest_palindrome):
                        longest_palindrome = s[i:j]
                        continue
                    k = 0
                    is_palindrome = True
                    while k < substring_length // 2:
                        if s[i+k] != s[j-k]:
                            is_palindrome = False
                            break
                        k += 1
                    if is_palindrome and len(s[i:j]) > len(longest_palindrome):
                        longest_palindrome = s[i:j+1]
                        continue
        return longest_palindrome


if __name__ == "__main__":
    s = Solution()

    print(s.naive_longest_palindromic_substring("babad"))  # -> "bab" or "aba"
    print(s.naive_longest_palindromic_substring("cbbd"))  # -> "bb"
