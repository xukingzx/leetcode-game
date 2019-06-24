package waitSolve;
import dataStruct.*;
public class BinTreeMaxPath_122 {
    int max = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        gainMaxValue(root);
        return max;
    }

    private int gainMaxValue(TreeNode root){
        int leftval = 0,rightval = 0;
        if(root.left == null && root.right == null) {
            max = Math.max(root.val,max);
            return root.val;
        }
        if(root.left != null) {
            leftval = Math.max(gainMaxValue(root.left),0);
        }
        if(root.right != null) {
            rightval = Math.max(gainMaxValue(root.right),0);

        }
        max = Math.max(root.val + leftval + rightval,max);
        return root.val + Math.max(leftval,rightval);
    }
}
