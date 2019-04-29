class Solution:
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

class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

if __name__ == '__main__':
    solution = Solution()
    nums = []
    target = 9931
    root = TreeNode(1)
    left1 = TreeNode(2)
    left2 = TreeNode(5)
    right = TreeNode(3)
    root.left = left1
    root.right = right
    left1.right = left2
    solution.binaryTreePaths(root)
    # a = [1, 2, 3]
    # b = a * 1
    # a[0] = 2
    # print(a)
    # print(b)
    # print(result)
