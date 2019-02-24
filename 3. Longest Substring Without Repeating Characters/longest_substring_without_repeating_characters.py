class Solution:
    """
    Given a string, find the length of the longest substring without repeating
    characters.

    Example 1:

    Input: "abcabcbb"
    Output: 3
    Explanation: The answer is "abc", with the length of 3.

    Example 2:

    Input: "bbbbb"
    Output: 1
    Explanation: The answer is "b", with the length of 1.

    Example 3:

    Input: "pwwkew"
    Output: 3
    Explanation: The answer is "wke", with the length of 3. Note that the
    answer must be a substring, "pwke" is a subsequence and not a substring.
    """

    def longest_substring_without_repeating_characters(self, s):
        """

        """
        seen = set()
        longest_substring_length = 0
        i = 0
        while i < len(s):
            current_substring_length = 0
            for j in range(i, len(s)):
                if s[j] not in seen:
                    seen.add(s[j])
                    current_substring_length += 1
                else:
                    if current_substring_length > longest_substring_length:
                        longest_substring_length = current_substring_length
                    seen.clear()
                    break
            i += 1
        return longest_substring_length


if __name__ == '__main__':
    s = Solution()
    print(s.longest_substring_without_repeating_characters("abcabcbb"))  # -> 3
    print(s.longest_substring_without_repeating_characters("bbbbb"))  # -> 1
    print(s.longest_substring_without_repeating_characters("pwwkew"))  # -> 3
