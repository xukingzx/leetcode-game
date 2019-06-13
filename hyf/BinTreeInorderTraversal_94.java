package solution;
import dataStruct.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinTreeInorderTraversal_94 {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> l = new ArrayList<>();
        Stack<TreeNode> s = new Stack<>();
        TreeNode temp = root;
        while(temp != null || s.empty() == false){
            if(temp != null){
                s.push(temp);
                temp = temp.left;
            }
            else{
                temp = s.pop();
                l.add(temp.val);
                temp = temp.right;
            }
        }
        return l;
    }
}
