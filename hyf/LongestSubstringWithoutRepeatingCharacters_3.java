package solution;

import java.util.HashMap;
import java.util.HashSet;

public class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring_v1(String s){
        int strlen = s.length();
        if(strlen == 0) return 0;
        else if(strlen == 1) return 1;
        int max = 1;
        for(int i = 0;i < strlen;i++){
            HashSet hs = new HashSet();
            hs.add(s.charAt(i));
            for(int j = i + 1 ;j < strlen;j++){
                if(hs.contains(s.charAt(j)) == true){
                    max = Math.max(max,hs.size());
                    break;
                }
                else{
                    hs.add(s.charAt(j));
                    max = Math.max(max,hs.size());
                }
            }
        }
        return max;
    }
    /*
        时间复杂度O(N^2)
        空间复杂度O(N)
        执行用时 : 255 ms, 在Longest Substring Without Repeating Characters的Java提交中击败了10.04% 的用户
        内存消耗 : 66.4 MB, 在Longest Substring Without Repeating Characters的Java提交中击败了13.68% 的用户
     */
    public int lengthOfLongestSubstring_v2(String s){
        int strlen = s.length(),max = 0,nextStart = 0;
        HashMap<Character,Integer>  m = new HashMap<>();
        for(int i = 0; i < strlen;i++){
            if(m.containsKey(s.charAt(i)) == false){
                m.put(s.charAt(i),i);
            }
            else{
                max = Math.max(max,i - nextStart);
                nextStart = m.get(s.charAt(i)) + 1;
                i = nextStart - 1;
                m.clear();
            }
        }
        return Math.max(max,m.size());
    }
    /*
        执行用时 : 175 ms, 在Longest Substring Without Repeating Characters的Java提交中击败了15.50% 的用户
        内存消耗 : 85.6 MB, 在Longest Substring Without Repeating Characters的Java提交中击败了8.47% 的用户
     */

        public int lengthOfLongestSubstring_v3(String s){
            int len = s.length(),i = 0,j = 0,max = 0;
            HashSet<Character> hs = new HashSet<>();
            char[] sc = s.toCharArray();
            while(i <= j && j < len){
                if(i == j) hs.add(sc[j++]);
                else{
                    if(hs.contains(sc[j]) == false) {
                        hs.add(sc[j]);
                        j++;
                    }
                    else{
                        max = Math.max(max,j - i);
                        hs.remove(sc[i]);
                        i++;
                    }
                }
            }
            return Math.max(max,hs.size());
        }
        /*
            滑动窗口
            执行用时 : 36 ms, 在Longest Substring Without Repeating Characters的Java提交中击败了59.13% 的用户
            内存消耗 : 39 MB, 在Longest Substring Without Repeating Characters的Java提交中击败了84.29% 的用户
         */

        //pwwwke
        public int lengthOfLongestSubstring_v4(String s){
            int len = s.length(),max = 0;
            HashMap<Character,Integer> m = new HashMap<>();
            char[] sc = s.toCharArray();
            for(int i = 0,j = 0;j < len;j++){
                if(m.containsKey(sc[j]) == true){
                    i = Math.max(m.get(sc[j]),i);
                }
                max = Math.max(max,j - i + 1);
                m.put(sc[j],j+1);
            }
            return max;
        }
        /*
            优化版滑动窗口，只需要遍历一遍，不需要回头看
            执行用时 : 28 ms, 在Longest Substring Without Repeating Characters的Java提交中击败了75.75% 的用户
            内存消耗 : 38.5 MB, 在Longest Substring Without Repeating Characters的Java提交中击败了87.84% 的用户
         */

    public int lengthOfLongestSubstring_v5(String s) {
        int max = 0,i = 0,pos = 0,start = 0,strlen = s.length();
        int length1 = 0,length2 = 0;
        while(i < strlen){
            pos = s.indexOf(s.charAt(i),start);
            if(pos < i){ //前面有一个与当前一样的字符
                length2 = i - start;
                max = Math.max(length1,Math.max(length2,max));
                length1 = i - pos;
                start = pos + 1;
            }
            else {
                length1++;
            }
            i++;
        }
        return Math.max(max,length1);
    }
    /*
    这是一个时间复杂度为O(N^2)的算法，但是用时却比上面O(N)用时少
    空间复杂度O(1)
    执行用时 : 10 ms, 在Longest Substring Without Repeating Characters的Java提交中击败了94.96% 的用户
    内存消耗 : 36.1 MB, 在Longest Substring Without Repeating Characters的Java提交中击败了98.92% 的用户
     */
}
