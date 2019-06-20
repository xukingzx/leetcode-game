package waitSolve;

import java.util.*;

public class CombinationSum2_40 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ll = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        Arrays.sort(candidates);
        find(ll,temp,candidates,target,0);
        return ll;
    }

    private void find(List<List<Integer>> ll,List<Integer> temp,int[] table,int target,int pos){
        if(target == 0){
            if(isUnique(ll,temp) == true)
                ll.add(temp);
            return;
        }
        if(target < 0) return;
        for(int i = pos;i < table.length && table[i] <= target;i++){
            List<Integer> list = new ArrayList<>(temp);
            list.add(table[i]);
            find(ll,list,table,target-table[i],i+1);
        }
    }

    public boolean isUnique(List<List<Integer>> ll,List<Integer> temp){
        Collections.sort(temp);
        for(List<Integer> item : ll){
            Collections.sort(item);
            if(item.equals(temp) == true) return false;
        }
        return true;
    }
}
