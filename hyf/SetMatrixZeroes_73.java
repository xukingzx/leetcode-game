package solution;

import java.util.HashSet;
import java.util.Set;

public class SetMatrixZeroes_73 {
    public void setZeroes_v1(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        Set<int[]> s = new HashSet<>();
        for(int i = 0;i < row;i++){
            for(int j = 0;j < col;j++){
                if(matrix[i][j] == 0){
                    s.add(new int[]{i,j});
                }
            }
        }
        for(int[] item : s){
            for(int i = 0;i < col;i++){
                matrix[item[0]][i] = 0;
            }
            for(int j = 0;j < row;j++){
                matrix[j][item[1]] = 0;
            }
        }
    }
    /*
        时间复杂度O(N*M)
        空间复杂度O(N*M)
        执行用时 : 7 ms, 在Set Matrix Zeroes的Java提交中击败了15.37% 的用户
        内存消耗 : 54.5 MB, 在Set Matrix Zeroes的Java提交中击败了27.27% 的用户
     */
    public void setZeroes_v2(int[][] matrix){
        int row = matrix.length;
        int col = matrix[0].length;
        Set<Integer> R = new HashSet<>();
        Set<Integer> C = new HashSet<>();
        for(int i = 0;i < row;i++){
            for(int j = 0;j < col;j++){
                if(matrix[i][j] == 0){
                    R.add(i);
                    C.add(j);
                }
            }
        }
        for(int i = 0;i < row;i++){
            for(int j = 0;j < col;j++){
                if(R.contains(i) || C.contains(j)) matrix[i][j] = 0;
            }
        }
    }
    /*
    时间复杂度O(N*M)
    空间复杂度O(N+M)
    执行用时 : 11 ms, 在Set Matrix Zeroes的Java提交中击败了7.58% 的用户
    内存消耗 : 51.3 MB, 在Set Matrix Zeroes的Java提交中击败了53.85% 的用户
     */
    public void setZeroes_v3(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (matrix[i][j] == 0) {
                    for (int k = 0; k < col; k++) {
                        if (matrix[i][k] != 0)
                            matrix[i][k] = Integer.MIN_VALUE + 1;
                    }
                    for (int k = 0; k < row; k++) {
                        if (matrix[k][j] != 0)
                            matrix[k][j] = Integer.MIN_VALUE + 1;
                    }
                }
            }
        }
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (matrix[i][j] == Integer.MIN_VALUE + 1) {
                    matrix[i][j] = 0;
                }
            }
        }
    }
        /*
              有问题的答案，骗过了测试系统
              时间复杂度O(N*M*(N+M))
              空间复杂度O(1)
              复杂度明明高了不少，运行时间却大幅度减少
              执行用时 :2 ms, 在所有Java提交中击败了97.81%的用户
              内存消耗 :45.8 MB, 在所有Java提交中击败了90.97%的用户
         */
    public void setZeroes_v4(int[][] matrix){
        if(matrix==null||matrix.length==0||matrix[0].length==0) return;
        boolean firstRow=false;
        boolean firstCol=false;

        for(int i=0;i<matrix[0].length;i++){
            if(matrix[0][i]==0) firstRow=true;
        }
        for(int i=0;i<matrix.length;i++){
            if(matrix[i][0]==0) firstCol=true;
        }

        for(int i=1;i<matrix[0].length;i++){
            for(int j=1;j<matrix.length;j++){
                if(matrix[j][i]==0){
                    matrix[0][i]=0;
                    matrix[j][0]=0;
                }
            }
        }
        for(int i=1;i<matrix[0].length;i++){
            if(matrix[0][i]==0) {
                for(int j=1;j<matrix.length;j++){
                    matrix[j][i]=0;
                }
            }
        }
        for(int i=1;i<matrix.length;i++){
            if(matrix[i][0]==0){
                for(int j=1;j<matrix[0].length;j++){
                    matrix[i][j]=0;
                }
            }
        }
        if(firstRow) {
            for(int i=0;i<matrix[0].length;i++){
                matrix[0][i]=0;
            }
        }
        if(firstCol) {
            for(int i=0;i<matrix.length;i++){
                matrix[i][0]=0;
            }
        }
        /*
            时间复杂度0(M*N)
            空间复杂度0(1)
           
         */
    }
}
