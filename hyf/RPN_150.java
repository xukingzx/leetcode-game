package waitsolve;

import java.util.Stack;

public class RPN_150 {
    public int evalRPN(String[] tokens) {
        Stack<Integer> ss = new Stack<>();
        int ret = 0;
        for(String str:tokens){
            if(isNum(str) == true){
                ss.push(Integer.valueOf(str).intValue());
            }
            else{
                int b = Integer.valueOf(ss.pop()).intValue();
                int a = Integer.valueOf(ss.pop()).intValue();
                if(str.charAt(0) == '+'){
                    ss.push(a + b);
                }
                else if(str.charAt(0) == '-'){
                    ss.push(a - b);
                }
                else if(str.charAt(0) == '*'){
                    ss.push(a * b);
                }
                else if(str.charAt(0) == '/'){
                    ss.push(a /b);
                }
            }
        }
        return ss.pop();
    }

    private boolean isNum(String str){
        char[] sc = str.toCharArray();
        if(sc[0] == '-'){
            if(sc.length > 1) return true;
            else return false;
        }
        else if(Character.isDigit(sc[0]) == true){
            return true;
        }
        return false;
    }
}
