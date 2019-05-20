from functools import reduce


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
    def isUgly(self, num):
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

    # 43. 字符串相乘
    def multiply(self, num1, num2):
        if num1 == '0' or num2 == '0':
            return '0'

    # 11. 盛最多水的容器
    def maxArea(self, height):
        max = 0
        i = 0
        j = len(height) - 1
        while i < j:
            print("i is:", i)
            print("j is:", j)
            s = (j - i) * (height[i] if height[i] < height[j] else height[j])
            print(s)
            if s > max:
                max = s
            if height[i] < height[j]:
                i += 1
            else:
                j -= 1
        return max

    # 5. 最长回文子串
    def longestPalindrome(self, s):
        max = ''
        for i in range(len(s)):
            j = 1
            temp = s[i]
            while i - j >= 0 and i + j < len(s):
                if s[i - j] != s[i + j]:
                    break
                temp = s[i - j] + temp + s[i + j]
                j += 1
            if len(temp) > len(max):
                max = temp
        for i in range(len(s) - 1):
            if s[i] == s[i + 1]:
                temp = s[i] * 2
                j = 1
                while i - j >= 0 and i + j + 1 < len(s):
                    if s[i - j] != s[i + j + 1]:
                        break
                    temp = s[i - j] + temp + s[i + j + 1]
                    j += 1
                if len(temp) > len(max):
                    max = temp
        return max

    # 198. 打家劫舍
    def rob(self, nums):
        if len(nums) == 1:
            return nums[0]
        if len(nums) == 2:
            return nums[0] if nums[0] > nums[1] else nums[1]
        a = nums[0]
        b = nums[1]
        return 1

    # 283. 移动零
    def moveZeroes(self, nums):
        j = 0
        for i in range(len(nums)):
            if nums[i] != 0:
                nums[j] = nums[i]
                j += 1
        for i in range(j, len(nums)):
            nums[i] = 0

    # 21. 合并两个有序链表
    def mergeTwoLists(self, l1, l2):
        head = ListNode(0)
        p = head
        while l1 is not None and l2 is not None:
            if l1.val < l2.val:
                p.next = l1
                l1 = l1.next
            else:
                p.next = l2
                l2 = l2.next
            p = p.next
        while l1 is not None:
            p.next = l1
            l1 = l1.next
            p = p.next
        while l2 is not None:
            p.next = l2
            l2 = l2.next
            p = p.next
        return head.next

    # 14. 最长公共前缀
    def longestCommonPrefix(self, strs):
        if len(strs) == 0:
            return ""
        if len(strs) == 1:
            return strs[0]
        temp = strs[0]
        for i in range(1, len(strs)):
            n = len(temp) if len(temp) < len(strs[i]) else len(strs[i])
            for j in range(n):
                if temp[j] != strs[i][j]:
                    break

    # 136. 只出现一次的数字
    def singleNumber(self, nums):
        return reduce(lambda x, y: x ^ y, nums)

    # 169. 求众数
    def majorityElement(self, nums) -> int:
        n = 0
        temp = nums[0]
        for item in nums:
            if item == temp:
                n += 1
            else:
                n -= 1
            if n < 0:
                temp = item
                n = 1
        return temp

    # 229. 求众数 II
    def majorityElement(self, nums):
        temp1 = 0
        temp2 = 0
        count1 = 0
        count2 = 0
        for item in nums:
            if item == temp1:
                count1 += 1
            elif item == temp2:
                count2 += 1
            else:
                count1 -= 1
                count2 -= 1
            print("temp1 is:{},temp2 is:{},count1 is:{}, count2 is:{}", temp1, temp2, count1, count2)
            if count1 < 0:
                temp1 = item
                count1 = 0
                continue
            if item == temp1:
                continue
            if count2 < 0:
                temp2 = item
                count2 = 0
        return [temp1, temp2]

    # 985. 查询后的偶数和
    def sumEvenAfterQueries(self, A, queries):
        list = []
        for item in queries:
            A[item[1]] += item[0]
            sum = reduce(lambda x, y: x + y, filter(lambda x: x & 1 == 0, A))
            list.append(sum)
        return list


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
    # root = TreeNode(1)
    # left1 = TreeNode(2)
    # left2 = TreeNode(5)
    # right = TreeNode(3)
    # root.left = left1
    # root.right = right
    # left1.right = left2
    # print(solution.myAtoi("123"))
    # print(solution.myAtoi("12147483648"))
    # print(solution.myAtoi("4193 with words"))
    # print(solution.myAtoi("  00   00 0"))
    # print(solution.myAtoi("   +0 123"))
    # print(solution.myAtoi("2147483648"))

    # l1 = ListNode(-9)
    # l1.next = ListNode(3)
    # l2 = ListNode(5)
    # l2.next = ListNode(7)
    # nums = [1, 2, 0, 3, 4]
    # print(printList(solution.mergeTwoLists(l1, l2)))

    # for i in range(10):
    #     print(i)
    #     if i == 9:
    #         break
    #
    # print(i)
    # a = [1, 2, 3]
    # b = a * 1
    # a[0] = 2
    # print(a)
    # print(b)
    # print(result)
    nums = [1, 1, 1, 3, 3, 3]
    B = filter(lambda x: x & 1 == 0, nums)
    print(len(list(B)))
    a = reduce(lambda x, y: x + y, B)
    print(a)
