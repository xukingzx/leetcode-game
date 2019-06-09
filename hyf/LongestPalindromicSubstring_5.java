package solution;

public class LongestPalindromicSubstring_5 {
    public String longestPalindrome_v1(String s) {
        int strlen = s.length();
        if (strlen == 0) return "";
        String temp = s.substring(0, 1);
        int max = 0;
        for (int i = 0; i < strlen; i++) {
            int j = i + 1;
            while (j < strlen) { //多此一举
                if (s.charAt(i) == s.charAt(j)) {
                    int k = i;
                    int l = j;
                    while (k <= l && s.charAt(k) == s.charAt(l)) {
                        k++;
                        l--;
                    }
                    if (k >= l) {
                        if (temp.length() < j - i + 1) temp = s.substring(i, j + 1);
                    }
                }
                j++;
            }
        }
        return temp;
    }

    /*
        时间复杂度O(N^3)
        空间复杂度O(1)
        执行用时 : 1485 ms, 在Longest Palindromic Substring的Java提交中击败了5.02% 的用户
        内存消耗 : 45.2 MB, 在Longest Palindromic Substring的Java提交中击败了41.17% 的用户
     */
    public String longestPalindrome_v2(String s) {
        int len = s.length();
        if (len == 0) {
            return "";
        }
        int longestPalindrome = 1;
        String longestPalindromeStr = s.substring(0, 1);
        for (int i = 0; i < len; i++) {
            String palindromeOdd = centerSpread(s, len, i, i);
            String palindromeEven = centerSpread(s, len, i, i + 1);
            String maxLenStr = palindromeOdd.length() > palindromeEven.length() ? palindromeOdd : palindromeEven;
            if (maxLenStr.length() > longestPalindrome) {
                longestPalindrome = maxLenStr.length();
                longestPalindromeStr = maxLenStr;
            }
        }
        return longestPalindromeStr;
    }

    private String centerSpread(String s, int len, int left, int right) {
        int l = left;
        int r = right;
        while (l >= 0 && r < len && s.charAt(l) == s.charAt(r)) {
            l--;
            r++;
        }
        // 这里要特别小心，跳出 while 循环的时候，是第 1 个满足 s.charAt(l) != s.charAt(r) 的时候
        // 所以，不能取 l，不能取 r
        return s.substring(l + 1, r);
    }
    /*
        O(N^2)
        O(1)
        执行用时 : 36 ms, 在Longest Palindromic Substring的Java提交中击败了59.76% 的用户
        内存消耗 : 46.3 MB, 在Longest Palindromic Substring的Java提交中击败了39.21% 的用户
     */

    public String longestPalindrome_v3(String s) {
        int strlen = s.length(), begin = 0, length = 1;
        if (strlen == 0) return null;
        if (strlen == 1) return s;
        char[] sc = s.toCharArray();
        char[][] dp = new char[strlen][strlen];
        for (int i = 0; i < strlen; i++) dp[i][i] = 1;
        for (int i = 1; i < strlen; i++) {
            if (sc[i - 1] == sc[i]) {
                dp[i - 1][i] = 1;
                begin = i - 1;
                length = 2;
            }
        }
        for (int interval = 3; interval <= strlen; interval++) {
            for (int i = 0; i <= strlen - interval; i++) {
                if (sc[i] == sc[i + interval - 1] && dp[i + 1][i + interval - 2] == 1) {
                    dp[i][i + interval - 1] = 1;
                    begin = i;
                    length = interval;
                }
            }
        }
        return s.substring(begin, begin + length);
    }
    /*
       使用动态规划
       时间复杂度O(N^2)
       空间间复杂度O(N^2)
       执行用时 : 81 ms, 在Longest Palindromic Substring的Java提交中击败了46.27% 的用户
       内存消耗 : 65.7 MB, 在Longest Palindromic Substring的Java提交中击败了17.04% 的用户
     */
}
