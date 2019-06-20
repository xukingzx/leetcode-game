package waitSolve;


import java.util.ArrayList;
import java.util.List;

public class SearchWords_79 {
    public boolean exist(char[][] board, String word) {
        int row = board.length;
        int col = board[0].length;
        List<int[]> visited = new ArrayList<>();
        for(int i = 0;i < row;i++){
            for(int j = 0;j < col;j++){
                if(word.charAt(0) == board[i][j]){
                    if(search(board,word,visited,i,j))
                        return true;
                }
            }
        }
        return false;
    }

    public boolean search(char[][] board,String word,List<int[]> visited,int i,int j){
        for(int[] item : visited){
            if(item[0] == i && item[1] == j) return false;
        }
        if(board[i][j] == word.charAt(0)) {
            if(word.length() == 1) return true;
            List<int[]> temp = new ArrayList<>(visited);
            temp.add(new int[]{i,j});
            if(i - 1 >= 0 && search(board,word.substring(1),temp,i-1,j)) return true;
            if(i + 1 < board.length&& search(board,word.substring(1),temp,i+1,j)) return true;
            if(j - 1 >= 0 &&search(board,word.substring(1),temp,i,j - 1)) return true;
            if(j + 1 < board[0].length &&search(board,word.substring(1),temp,i,j + 1)) return true;
        }
        return false;
    }

}
