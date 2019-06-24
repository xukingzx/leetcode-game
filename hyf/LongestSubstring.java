package waitSolve;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LongestSubstring {
    public int longestSubstring(String s, int k) {
        int strLength = s.length();
        int longestSubPos = 0;
        for(int startChar = 0;startChar < strLength;startChar++) {
            HashMap<Character,Integer> charOccurences = new HashMap<>();
            for (int i = startChar; i < strLength; i++) {
                boolean greaterThanK = true;
                char c = s.charAt(i);
                if (charOccurences.containsKey(s.charAt(i)) == false) {
                    charOccurences.put(c, 1);
                } else {
                    charOccurences.put(c, charOccurences.get(c) + 1);
                }
                for (int value : charOccurences.values()) {
                    if (value < k) {
                        greaterThanK = false;
                        break;
                    }
                }
                if (greaterThanK == true) {
                    longestSubPos = Math.max( i  - startChar + 1,longestSubPos);
                }
            }
        }
        return longestSubPos;
    }

    public int longestSubstring_v2(String s, int k) {
        HashMap<Character,Integer>map=new HashMap<>();//只计数
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            if(!map.containsKey(c)){
                map.put(c,1);
            }else{
                map.put(c,map.get(c)+1);
            }
        }
        //分成2个字串
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            int j=i;//这一步只是为了不超时做的努力,如果去掉，直接return会超时
            if(map.get(c)<k){  //  如果字符出现次数 < k，那么该字符不可能出现在最终要求的子串中，在该字符的位置对原字符串进行截断
                for(;j<s.length();j++){
                    if(s.charAt(j)!=c)
                        break;
                }
                // 根据该字符的位置对字符串进行截断，判断左右两个截断的字字符哪个更长
                return Math.max(longestSubstring_v2(s.substring(0,i),k),longestSubstring_v2(s.substring(j),k));
            }
        }
        return s.length();
    }
}
