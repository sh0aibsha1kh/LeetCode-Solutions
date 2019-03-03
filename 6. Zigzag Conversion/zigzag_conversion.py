class Solution:
    """
    The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)

    P   A   H   N
    A P L S I I G
    Y   I   R
    And then read line by line: "PAHNAPLSIIGYIR"

    Example 1:

    Input: s = "PAYPALISHIRING", numRows = 3
    Output: "PAHNAPLSIIGYIR"

    Example 2:

    Input: s = "PAYPALISHIRING", numRows = 4
    Output: "PINALSIGYAHRPI"
    Explanation:

    P     I    N
    A   L S  I G
    Y A   H R
    P     I
    """

    def naive_zigzag_conversion(self, s, num_rows):
        """
        Create an empty s x n matrix. Start by adding the characters to the
        matrix going down. Once you hit the last row, zigzag back up. At the
        end, go through the matrix once more and concatenate the zigzagged
        values to a new string and return it.
        Time Complexity: O(s*n)
        """
        matrix = [['0' for i in range(len(s))] for j in range(num_rows)]
        i = 0
        j = 0
        zigzag_start = False
        for char in s:
            if zigzag_start:
                i -= 1
                j += 1
                matrix[i][j] = char
            if i == 0:
                zigzag_start = False
            if not zigzag_start:
                matrix[i][j] = char
                i += 1
            if i == num_rows:
                i -= 1
                zigzag_start = True

        zigzag = ""
        for row in matrix:
            for col in row:
                if col != "0":
                    zigzag += col
        return zigzag


if __name__ == "__main__":
    s = Solution()
    print(s.naive_zigzag_conversion("PAYPALISHIRING", 3))  # -> "PAHNAPLSIIGYIR"
    print(s.naive_zigzag_conversion("PAYPALISHIRING", 4))  # -> "PINALSIGYAHRPI"
