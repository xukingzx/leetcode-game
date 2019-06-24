package waitSolve;

import java.util.Arrays;

public class SearchMatrix2_240 {
    public boolean searchMatrix_v1(int[][] matrix, int target) {
        int row = matrix.length;
        if(row == 0) return false;
        int col = matrix[0].length;
        for(int i = 0;i < row;i++){
            if(Arrays.binarySearch(matrix[i],target) >= 0) return true;
        }
        return false;
    }
}

