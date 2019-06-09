package solution;

import java.util.ArrayList;
import java.util.List;

public class ZigZag_6 {
    public String convert(String s, int numRows) {
        int strlen = s.length();
        if(strlen == 0) return "";
        else if(numRows == 0 || numRows == 1) return s;
        char[][] array = new char[numRows][strlen];
        int row = 0,col = 0;
        boolean raising = false;
        for(int i = 0;i < strlen;i++){
            array[row][col] = s.charAt(i);
            if(raising == false){
                if(row < numRows - 1){
                    row++;
                }
                else{
                    row--;
                    col++;
                    raising = true;
                }
            }
            else{
                if(row > 0){
                    row--;
                    col++;
                }
                else{
                    row++;
                    raising = false;
                }
            }
        }
        StringBuffer str = new StringBuffer();
        for(int i = 0;i < numRows;i++)
            for(int j = 0;j < strlen;j++)
                if(array[i][j] != '\u0000') str.append(array[i][j]);
        return str.substring(0,strlen);
    }
    /*
        时间复杂度O(N*M)
        空间复杂度O(N*M)
        执行用时 : 74 ms, 在ZigZag Conversion的Java提交中击败了23.10% 的用户
        内存消耗 : 65.1 MB, 在ZigZag Conversion的Java提交中击败了18.49% 的用户
     */

    public String convert_v2(String s, int numRows) {
        int strlen = s.length();
        if(strlen <= numRows) return s;
        if(numRows == 1) return s;
        List<StringBuffer> rows = new ArrayList<>();
        for(int i = 0 ;i < numRows;i++) rows.add(new StringBuffer());
        boolean godown = false;
        int currow = 0;
        for(char c : s.toCharArray()){
            rows.get(currow).append(c);
            if(currow == 0 || currow == numRows - 1) godown = !godown;
            currow += godown?1:-1;
        }
        StringBuffer s1 = new StringBuffer();
        for(StringBuffer item : rows){
            s1.append(item);
        }
        return s1.toString();
    }
    /*
        时间复杂度O(N)
        空间复杂度O(N)
        执行用时 : 29 ms, 在ZigZag Conversion的Java提交中击败了60.18% 的用户
        内存消耗 : 44.8 MB, 在ZigZag Conversion的Java提交中击败了70.46% 的用户
     */

    public String convert_v3(String s, int numRows) {
        if (numRows == 1) return s;
        StringBuilder ret = new StringBuilder();
        int n = s.length();
        int cycleLen = 2 * numRows - 2;

        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j + i < n; j += cycleLen) {
                ret.append(s.charAt(j + i));
                if (i != 0 && i != numRows - 1 && j + cycleLen - i < n)
                    ret.append(s.charAt(j + cycleLen - i));
            }
        }
        // \.\.\.\先求斜线，再求点
        return ret.toString();
    }
    /*
        时间复杂度O(N)
        空间复杂度O(N)
        执行用时 : 8 ms, 在ZigZag Conversion的Java提交中击败了99.34% 的用户
        内存消耗 : 36.9 MB, 在ZigZag Conversion的Java提交中击败了99.45% 的用户
     */
}
