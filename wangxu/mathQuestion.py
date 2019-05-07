class Solution:
    list = []

    # 1. 两数之和
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

    # 268. 缺失数字
    def missingNumber(self, nums):
        list = [0] * (len(nums) + 1)
        for i in range(len(nums)):
            list[nums[i]] = 1
        for i in range(len(nums) + 1):
            if list[i] == 0:
                return i
        return len(nums)

    # 344. 反转字符串
    def reverseString(self, s) -> None:
        """
        Do not return anything, modify s in-place instead.
        """
        i = 0
        j = len(s) - 1
        while i < j:
            temp = s[i]
            s[i] = s[j]
            s[j] = temp
            i += 1
            j -= 1

    # 231. 2的幂
    def isPowerOfTwo(self, n: int) -> bool:
        if n == 0:
            return False
        if n & (n - 1) == 0:
            return True
        return False

    # 2. 两数相加
    def addTwoNumbers(self, l1, l2):
        head = ListNode(0)
        p = head
        temp = 0
        while l1 is not None and l2 is not None:
            n = l1.val + l2.val + temp
            p.next = ListNode(n % 10)
            temp = n // 10
            p = p.next
            l1 = l1.next
            l2 = l2.next
        while l1 is not None:
            n = l1.val + temp
            p.next = ListNode(n % 10)
            temp = n // 10
            p = p.next
            l1 = l1.next
        while l2 is not None:
            n = l2.val + temp
            p.next = ListNode(n % 10)
            temp = n // 10
            p = p.next
            l2 = l2.next
        if temp == 1:
            p.next = ListNode(1)
        return head.next

    # 263. 丑数
    def isUgly(self, num: int) -> bool:
        while num != 1:
            temp = num
            if num / 2 == num // 2:
                num /= 2
            if num / 3 == num // 3:
                num /= 3
            if num / 5 == num // 5:
                num /= 5
            if temp == num:
                return False
        return True


class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None


def printList(list):
    while list is not None:
        print(list.val)
        list = list.next


if __name__ == '__main__':
    solution = Solution()
    root = TreeNode(1)
    left1 = TreeNode(2)
    left2 = TreeNode(5)
    right = TreeNode(3)
    root.left = left1
    root.right = right
    left1.right = left2
    # print(solution.myAtoi("123"))
    # print(solution.myAtoi("12147483648"))
    # print(solution.myAtoi("4193 with words"))
    # print(solution.myAtoi("  00   00 0"))
    # print(solution.myAtoi("   +0 123"))
    # print(solution.myAtoi("2147483648"))
    l1 = ListNode(2)
    l1.next = ListNode(4)
    l1.next.next = ListNode(3)
    l2 = ListNode(5)
    l2.next = ListNode(6)
    l2.next.next = ListNode(4)
    l2.next.next.next = ListNode(4)
    print(printList(solution.addTwoNumbers(l1, l2)))

    # a = [1, 2, 3]
    # b = a * 1
    # a[0] = 2
    # print(a)
    # print(b)
    # print(result)
