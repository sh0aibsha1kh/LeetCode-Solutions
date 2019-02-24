class Solution:
    def two_sum_naive(self, nums, target):
        for i in range(len(nums)):
            for j in range(len(nums)):
                if nums[i] + nums[j] == target:
                    return [i, j]

    def two_sum(self, nums, target):
        my_dict = dict()
        for i in range(len(nums)):
            if target-nums[i] in my_dict:
                return [my_dict.get(target-nums[i]), i]
            else:
                my_dict[nums[i]] = i

if __name__ == '__main__':
    solution = Solution()
    print(solution.two_sum_naive([1, 3, 5, 7], 10))  # -> [1, 3]
    print(solution.two_sum([1, 3, 5, 7], 8))  # -> [1, 2]
