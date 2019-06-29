package waitsolve;

import java.util.ArrayList;
import java.util.List;

public class SplitPalindrome_131 {
    /*List<List<String>> result = new ArrayList<>();
    public List<List<String>> partition(String s) {
        char[] str = s.toCharArray();
        int[] palindormeLength = new int[str.length];
        //for(int i = 0;i < palindormeLength.length;i++) palindormeLength[i] = 1;
        palindormeLength[0] = 1;
        for(int i = 0;i < str.length;i++){
            for(int j = 1;i + j <= str.length;j++){
                if(isPalindrome(String.copyValueOf(str,i,j)) == true){
                    palindormeLength[i + j - 1] = Math.max(palindormeLength[i + j - 1],j);
                }
            }
        }
        return null;
    }
    void split(int[] palidormeLength,String str,int pos,List<String> palidormelist){

        for(int i = pos;i < str.length() && palidormeLength[i + 1] == 1;i++){
            palidormelist.add(str.substring(i,1));
        }
    }
     */

    List<List<String>> res=new ArrayList<>();
    public List<List<String>> partition(String s) {
        if(s==""||s.length()==0){
            return res;
        }
        List<String> list=new ArrayList<>();
        backTracing(list,s,0);
        return res;
    }
    public void backTracing(List<String> list,String s, int i){
        if(i==s.length()){
            res.add(list);
        }
        for(int j=i+1;j<=s.length();++j){
            if(isParlindrome(s.substring(i,j))){
                list.add(s.substring(i,j));
                backTracing(new ArrayList<String> (list),s,j);
                list.remove(list.size()-1);
            }
        }
    }

    private boolean isParlindrome(String s) {
        char[] str = s.toCharArray();
        boolean palindrome = true;
        int left = 0;
        int right = str.length - 1;
        while (left <= right){
            if(str[left] == str[right]){
                left++;
                right--;
            }
            else{
                palindrome = false;
                break;
            }
        }
        return palindrome;
    }
}
