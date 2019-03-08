class Solution:
    """
    Given a string s, find the longest palindromic substring in s. You may 
    assume that the maximum length of s is 1000.

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

    def longest_palindromic_substring(self, s):
        """
        Go through each character in the string and create a "boundary" that
        continues to expand outwards while the characters at the boundary also
        match. Keep track of the largest boundary and return that substring.
        For the case where the length of the string is even, go through the
        string two characters at a time to find a match and then expand the
        boundary outward.
        Time Complexity: O(n^2)
        """
        n = len(s)
        if n == 0:
            return ""
        longest_palindrome = s[0]

        for i in range(n):
            boundary = 1
            while i - boundary >= 0 and \
            i + boundary < n and \
            s[i-boundary] == s[i+boundary]:
                if 2 * (boundary) + 1 > len(longest_palindrome):
                    longest_palindrome = s[i - boundary: i+boundary+1]
                boundary += 1
                
        for i in range(n-1):
            boundary = 1
            j = i + 1
            if s[i] == s[j]:
                if len(s[i:j+1]) > len(longest_palindrome):
                    longest_palindrome = s[i:j+1]
                while i - boundary >= 0 and \
                j + boundary < n and \
                s[i-boundary] == s[j+boundary]:
                    if 2 * (boundary) + 2 > len(longest_palindrome):
                        longest_palindrome = s[i - boundary: j+boundary+1]
                    boundary += 1

        return longest_palindrome

if __name__ == "__main__":
    s = Solution()
    print(s.longest_palindromic_substring("babad"))  # -> "bab"
    print(s.longest_palindromic_substring("cbbd"))  # -> "bb"
    print(s.longest_palindromic_substring("abcd"))  # -> "a"
    print(s.longest_palindromic_substring("bananas"))  # -> "anana"
