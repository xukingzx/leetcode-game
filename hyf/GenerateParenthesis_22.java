package waitSolve;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GenerateParenthesis_22 {
    List<String> ls = new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        char[] s = new char[n * 2];
        s[0] = '(';
        f(n*2,s,0,1,0);
        return ls;
    }

    private void f(int n,char[] c,int pos,int num_l,int num_r){
        if(pos == n - 1){
            ls.add(String.copyValueOf(c));
            return;
        }
        char[] temp = new char[n];
        temp = Arrays.copyOf(c,n);
        int tempPos = pos;
        tempPos++;
        if(num_l < n / 2) {
            temp[tempPos] = '(';
            int temp_num_l = num_l;
            temp_num_l++;
            f(n,temp,tempPos,temp_num_l,num_r);
        }
        if(num_r < n /2){
            if(num_l == num_r) return;
            temp[tempPos] = ')';
            int temp_num_r = num_r;
            temp_num_r++;
            f(n,temp,tempPos,num_l,temp_num_r);
        }
    }
}
