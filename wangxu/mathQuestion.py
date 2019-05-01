class Solution:
    list = []

    def twoSum(self, nums, target):
        sum_map = {}
        for i in range(len(nums)):
            if target - nums[i] in sum_map:
                return [sum_map[target - nums[i]], i]
            else:
                sum_map[nums[i]] = i
        return []

    # 202. Happy Number
    def twoSum1(self, nums, target):
        for i in range(len(nums) - 1):
            for j in range(i + 1, len(nums)):
                if nums[i] + nums[j] == target:
                    return [i, j]
        return []

    # 713. Subarray Product Less Than K
    def numSubarrayProductLessThanK(self, nums, k):
        if k < 1:
            return 0
        count = 0
        left = 0
        right = 0
        s = 1
        while right < len(nums):
            s *= nums[right]
            right += 1
            while s >= k:
                s /= nums[left]
                left += 1
            count += right - left
        return count

    # Definition for a binary tree node.
    # class TreeNode:
    #     def __init__(self, x):
    #         self.val = x
    #         self.left = None
    #         self.right = None
    def binaryTreePaths(self, root):
        if root is not None:
            print(root.val, "->")
        if root.left is not None:
            self.binaryTreePaths(root.left)
        if root.right is not None:
            self.binaryTreePaths(root.right)

    # 713. 字符串转换整数 (atoi)
    def myAtoi(self, str):
        str = str.lstrip()
        if len(str) == 0:
            return 0
        flag = False
        if str[0] == '-':
            flag = True
            str = str[1:]
        elif str[0] == '+':
            str = str[1:]
        while len(str) > 0:
            if str[0] == '0':
                str = str[1:]
            else:
                break
        if len(str) == 0:
            return 0
        if str[0] < '0' or str[0] > '9':
            return 0
        for i in range(len(str)):
            if str[i] < '0' or str[i] > '9':
                str = str[:i]
                break
        if len(str) > 10 or (len(str) == 10 and str >= '2147483648'):
            if flag:
                return -2147483648
            else:
                return 2147483647
        sum = 0
        for i in range(len(str)):
            sum = sum * 10 + ord(str[i]) - 48
        if flag:
            return -sum
        else:
            return sum


class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


if __name__ == '__main__':
    solution = Solution()
    root = TreeNode(1)
    left1 = TreeNode(2)
    left2 = TreeNode(5)
    right = TreeNode(3)
    root.left = left1
    root.right = right
    left1.right = left2
    print(solution.myAtoi("123"))
    print(solution.myAtoi("12147483648"))
    print(solution.myAtoi("4193 with words"))
    print(solution.myAtoi("  00   00 0"))
    print(solution.myAtoi("   +0 123"))
    print(solution.myAtoi("2147483648"))
    # a = [1, 2, 3]
    # b = a * 1
    # a[0] = 2
    # print(a)
    # print(b)
    # print(result)
