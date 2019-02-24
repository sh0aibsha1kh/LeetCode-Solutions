class Solution:
    """
    Given an array of integers, return indices of the two numbers such that 
    they add up to a specific target.

    You may assume that each input would have exactly one solution, and you may
    not use the same element twice.

    Example:

    Given nums = [2, 7, 11, 15], target = 9,

    Because nums[0] + nums[1] = 2 + 7 = 9,
    return [0, 1].
    """

    def naive_two_sum(self, nums, target):
        """
        Loop through every possible pair of numbers in the array.
        Time complexity: O(n^2)
        """
        for i in range(len(nums)):
            for j in range(len(nums)):
                if nums[i] + nums[j] == target:
                    return [i, j]

    def two_sum(self, nums, target):
        """
        Loop through the array once while storing the values and indices inside
        a dictionary to help retrieve the complementary index.
        Time complexity: O(n)
        """
        my_dict = dict()
        for i in range(len(nums)):
            if target-nums[i] in my_dict:
                return [my_dict.get(target-nums[i]), i]
            else:
                my_dict[nums[i]] = i


if __name__ == '__main__':
    solution = Solution()
    print(solution.two_sum([1, 3, 5, 7], 10))  # -> [1, 3]
    print(solution.two_sum([1, 3, 5, 7], 8))  # -> [1, 2]
