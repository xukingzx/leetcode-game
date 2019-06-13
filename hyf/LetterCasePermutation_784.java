package solution;

import java.util.ArrayList;
import java.util.List;

public class LetterCasePermutation_784 {
    public List<String> letterCasePermutation_v1(String S) {
        List<String> l = new ArrayList<>();
        l.add("");
        for(int i = 0;i < S.length();i++){
            List<String> tempL = new ArrayList<>();
            for(int j = 0;j < l.size();j++){
                if(Character.isDigit(S.charAt(i)) == false){
                    if(Character.isLowerCase(S.charAt(i)) == true)
                        tempL.add(l.get(j) + Character.toUpperCase(S.charAt(i)));
                    else
                        tempL.add(l.get(j) + Character.toLowerCase(S.charAt(i)));
                }
                tempL.add(l.get(j) + S.charAt(i));
            }
            l = tempL;
        }
        return l;
    }

    List<String> l = new ArrayList<>();
    public List<String> letterCasePermutation_v2(String S) {
        dfs(new StringBuffer(S),0);
        return l;
    }
    private void dfs(StringBuffer s,int num){
        if(num == s.length()){
            l.add(s.toString());
            return;
        }
        else{
            if(Character.isDigit(s.charAt(num)) == true)
                dfs(s,num+1);
            else{
                char ch = s.charAt(num);
                s.setCharAt(num,Character.toLowerCase(ch));
                dfs(s,num+1);
                s.setCharAt(num,Character.toUpperCase(ch));
                dfs(s,num+1);
            }
        }
    }

}
