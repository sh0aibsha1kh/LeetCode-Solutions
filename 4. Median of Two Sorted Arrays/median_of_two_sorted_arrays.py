class Solution:
    """
    There are two sorted arrays nums1 and nums2 of size m and n respectively.

    Find the median of the two sorted arrays. The overall run time complexity
    should be O(log (m+n)).

    You may assume nums1 and nums2 cannot be both empty.

    Example 1:

    nums1 = [1, 3]
    nums2 = [2]

    The median is 2.0

    Example 2:

    nums1 = [1, 2]
    nums2 = [3, 4]

    The median is (2 + 3)/2 = 2.5
    """

    def naive_median_of_two_sorted_arrays(self, nums1,  nums2):
        """
        Merge both sorted arrays and return the middle element.
        Time Complexity: O(n+m)
        """
        merged = []
        num1_length = len(nums1)
        num2_length = len(nums2)
        i = 0
        j = 0

        while i < num1_length and j < num2_length:
            if nums1[i] <= nums2[j]:
                merged.append(nums1[i])
                i += 1
            else:
                merged.append(nums2[j])
                j += 1

        while i < num1_length:
            merged.append(nums1[i])
            i += 1

        while j < num2_length:
            merged.append(nums2[j])
            j += 1

        if len(merged) % 2 == 0:
            return (merged[(len(merged)) // 2]
                    + merged[(len(merged) // 2) - 1]) / 2
        else:
            return merged[len(merged) // 2]

    def median_of_two_sorted_arrays(self, nums1, nums2):
        """
        The idea here is to partition both arrays in such a way that the number
        of elements on the left side and right side are both equal. Since we
        know that the left and right partitions are of equal sizes, then if
        the maximum element on the left is less than the minimum element on the
        right for both partitioned arrays, we have found the median.
        Time Complexity: O(log(min(n,m)))
        """
        if len(nums1) > len(nums2):
            return self.median_of_two_sorted_arrays(nums2, nums1)

        MAX_VALUE = 999999999
        MIN_VALUE = -999999999

        x = len(nums1)
        y = len(nums2)
        is_even = True if (x+y) % 2 == 0 else False
        i_min = 0
        i_max = x

        if is_even:
            if x == 0:
                return (nums2[y // 2] + nums2[(y // 2) - 1]) / 2
            if y == 0:
                return (nums1[x // 2] + nums1[(x // 2) - 1]) / 2
        else:
            if x == 0:
                return nums2[y // 2]
            if y == 0:
                return nums1[x // 2]

        while i_min <= i_max:
            x_partition = (i_min + i_max) // 2
            y_partition = (x + y + 1) // 2 - x_partition

            x_left = MIN_VALUE if x_partition == 0 else nums1[x_partition - 1]
            x_right = MAX_VALUE if x_partition == x else nums1[x_partition]

            y_left = MIN_VALUE if y_partition == 0 else nums2[y_partition - 1]
            y_right = MAX_VALUE if y_partition == y else nums2[y_partition]

            if x_left <= y_right and y_left <= x_right:
                if is_even:
                    return (max(x_left, y_left) + min(x_right, y_right)) / 2
                else:
                    return max(x_left, y_left)

            elif x_left > y_right:
                i_max = x_partition - 1

            else:
                i_min = x_partition + 1


if __name__ == '__main__':
    s = Solution()
    print(s.median_of_two_sorted_arrays([1, 3], [2]))  # -> 2
    print(s.median_of_two_sorted_arrays([1, 2], [3, 4]))  # -> 2.5
    print(s.median_of_two_sorted_arrays([2], []))  # -> 2
    print(s.median_of_two_sorted_arrays([1, 2, 3, 5, 6], [4]))  # -> 3.5
    print(s.median_of_two_sorted_arrays([3, 4, 5, 6], [1, 2]))  # -> 3.5
    print(s.median_of_two_sorted_arrays([1, 2], [3, 4]))  # -> 2.5
    print(s.median_of_two_sorted_arrays([], [2, 3]))  # -> 2.5
