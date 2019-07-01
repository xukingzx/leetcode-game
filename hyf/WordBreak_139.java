package waitsolve;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordBreak_139 {

    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> stringSet = new HashSet<>(wordDict);
        return f(s,stringSet);
    }

    private boolean f(String s,Set<String> stringSet){
        if(s.equals("") == true) return true;
        for(int i = 0;i <= s.length();i++){
            if(stringSet.contains(s.substring(0,i)) == true){
                if(f(s.substring(i),stringSet) == true){
                    return true;
                }
            }
        }
        return false;
    }
    /*
        回溯法，超时
     */
    public boolean wordBreak_v2(String s, List<String> wordDict) {
        Set<String> stringSet = new HashSet<>(wordDict);
        Boolean[] isWord = new Boolean[s.length()];
        return g(s,0,stringSet,isWord);
    }
    private boolean g(String s,int start,Set<String> stringSet,Boolean[] isWord){
        int strLen = s.length();
        if(start == strLen) return true;
        if(isWord[start] != null) return isWord[start];
        for(int end = start + 1;end <= strLen;end++){
            if(stringSet.contains(s.substring(start,end)) == true){
                if(g(s,end,stringSet,isWord) == true){
                    return isWord[start] = true;
                }
            }
        }
        return isWord[start] = false;
    }
    /*
        用boolean数组依然超时
        用Boolean却可以
     */

    public boolean wordBreak_v3(String s, List<String> wordDict) {
        Set<String> wordDictSet=new HashSet(wordDict);
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && wordDictSet.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }
}
