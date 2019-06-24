package waitSolve;

import java.util.Arrays;

public class SearchMatrix_74 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length;
        if(row == 0) return false;
        int col = matrix[0].length;
        if(col == 0) return false;
        if(matrix[0][0] > target || matrix[row-1][col-1] < target) return false;
        int index = 0;
        for(int i = 0;i < row;i++){
            if(matrix[i][0] <= target && matrix[i][col - 1] >= target){
                index = i;
                break;
            }
        }
        return Arrays.binarySearch(matrix[index],target) >= 0?true:false;
    }
}
