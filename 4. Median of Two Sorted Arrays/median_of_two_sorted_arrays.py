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


if __name__ == '__main__':
    s = Solution()
    print(s.naive_median_of_two_sorted_arrays([1, 3], [2]))  # -> 2.0
    print(s.naive_median_of_two_sorted_arrays([1, 2], [3, 4]))  # -> 2.5
