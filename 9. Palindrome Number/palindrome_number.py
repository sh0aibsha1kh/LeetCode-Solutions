class Solution:
    """
    Determine whether an integer is a palindrome. An integer is a palindrome
    when it reads the same backward as forward.

    Example 1:

    Input: 121
    Output: true

    Example 2:

    Input: -121
    Output: false
    Explanation: From left to right, it reads -121. From right to left, it 
    becomes 121-. Therefore it is not a palindrome.

    Example 3:

    Input: 10
    Output: false
    Explanation: Reads 01 from right to left. Therefore it is not a palindrome.
    """

    def palindrome_number(self, x):
        """
        Compare the i'th first and the i'th last character until they no longer
        match up.
        Time Complexity: O(n)
        """
        if x < 0:
            return False
        x = str(x)
        is_palindrome = True
        i = 0
        while i < len(x) // 2:
            if x[i] != x[len(x) - 1 - i]:
                is_palindrome = False
            i += 1
        return is_palindrome


if __name__ == "__main__":
    s = Solution()
    print(s.palindrome_number(121))  # -> True
    print(s.palindrome_number(-121))  # -> False
    print(s.palindrome_number(10))  # -> False
