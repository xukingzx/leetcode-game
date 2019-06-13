package solution;

import java.util.*;

public class PhoneLetter_17 {
    List<String> ls = new ArrayList<>();
    HashMap<String, String> m = new HashMap<>() {{
        put("2","abc");
        put("3","def");
        put("4","ghi");
        put("5","jkl");
        put("6","mno");
        put("7","pqrs");
        put("8","tuv");
        put("9","wxyz");
    }};

    public void backtrack(String combination,String next_digit){
        if(next_digit.length() == 0)
            ls.add(combination);
        else {
            String digit = next_digit.substring(0,1);
            String letters = m.get(digit);
            for(int i = 0;i < letters.length();i++){
                String letter = m.get(digit).substring(i,i+1);
                backtrack(combination+letter,next_digit.substring(1));
            }
        }
    }
    public List<String> letterCombinations_v1(String digits) {
        if(digits.length() != 0)
            backtrack("",digits);
        return ls;
    }
    public void show(){
        for(int i = 0;i < ls.size();i++){
            System.out.print(ls.get(i)+" ");
        }
    }
    public List<String> letterCombinations_v2(String digits) {
        //List<String> ls = new ArrayList<>();
        ls.add("");
        String charmap[] = {"0","1","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        for(int i = 0;i < digits.length();i++){
            List<String> temp = new ArrayList<>();
            String chars = charmap[digits.charAt(i) - '0'];
            for(int c = 0;c < chars.length();c++){
                for(int j = 0;j < ls.size();j++){
                    temp.add(ls.get(j)+chars.charAt(c));
                }
            }
            ls = temp;
        }
        return ls;
    }
}
