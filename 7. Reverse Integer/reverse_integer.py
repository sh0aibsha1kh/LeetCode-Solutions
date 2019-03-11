class Solution:
    """
    Given a 32-bit signed integer, reverse digits of an integer.

    Example 1:

    Input: 123
    Output: 321

    Example 2:

    Input: -123
    Output: -321

    Example 3:

    Input: 120
    Output: 21

    Note:
    Assume we are dealing with an environment which could only store integers 
    within the 32-but signed integer range: [-231, 231 - 1]. For the purpose of
    this problem, assume that your function returns 0 when the reversed integer
    overflows.
    """

    def naive_reverse_integer(self, x):
        """
        Create a boolean to check if the value is negative. Based on that,
        convert the integer into a digit array including/excluding the '-' if
        it's negative. After reversing the digit array, ignore all of the
        leading zeroes. Finally, if the reversed number is out of bounds,
        return 0. Otherwise, return the reversed number.
        Time Complexity: O(n)
        """

        is_negative = True if x < 0 else False

        if (is_negative and x > -10) or (not is_negative and x / 10 == 0):
            return x

        if is_negative:
            digit_list = [i for i in str(x)[1:]]
        else:
            digit_list = [i for i in str(x)]

        digit_list = digit_list[::-1]

        i = 0
        while digit_list[i] == '0' and i < len(digit_list):
            i += 1

        if is_negative:
            reversed_integer = int("-" + ''.join(digit_list[i::]))
        else:
            reversed_integer = int(''.join(digit_list[i::]))

        if reversed_integer < -2**31 or reversed_integer > 2**31 - 1:
            return 0
        return reversed_integer

    def reverse_integer(self, x):
        """
        Similar runtime as the naive implementation, but the code is much more
        clean and easier to understand. If the number is positive, cast it to a
        string and reverse it before casting it back to an int. If it's a
        negative number then do the same as above without including the
        negative sign, and then add it back to the reversed string before
        casting to an int.
        Time Complexity: O(n)
        """
        reversed = None
        if x >= 0:
            reversed = int(str(x)[::-1])
        else:
            reversed = int('-' + (str(x)[1::])[::-1])

        if reversed < -2**31 or reversed > 2**31 - 1:
            return 0
        return reversed


if __name__ == "__main__":
    s = Solution()
    print(s.reverse_integer(123))  # -> 321
    print(s.reverse_integer(-123))  # -> -321
    print(s.reverse_integer(120))  # -> 21
    print(s.reverse_integer(0))  # -> 0
    print(s.reverse_integer(-10))  # -> -1
    print(s.reverse_integer(1534236469))  # -> 0
