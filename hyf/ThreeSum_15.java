package solution;

import java.util.*;

public class ThreeSum_15 {
    public List<List<Integer>> threeSum_v1(int[] nums) {
        int len = nums.length;
        List<List<Integer>> LL = new ArrayList<List<Integer>>();
        if(len < 3) return LL;
        Set<Set<Integer>> SS = new HashSet<Set<Integer>>();
        for(int i = 0;i < len;i++){
            for(int j = i + 1;j < len;j++){
                for(int k = j + 1;k < len;k++){
                    if(nums[i] + nums[j] + nums[k] == 0){
                        Set<Integer> S = new HashSet<Integer>();
                        S.add(nums[i]);
                        S.add(nums[j]);
                        S.add(nums[k]);
                        if(SS.contains(S) == false) {
                            List<Integer> L = new ArrayList<Integer>();
                            L.add(nums[i]);L.add(nums[j]);L.add(nums[k]);
                            LL.add(L);
                            SS.add(S);
                        }
                    }
                }
            }
        }
        return LL;
    }
    /*
        超时
     */
    public List<List<Integer>> threeSum_v2(int[] nums) {
        List<List<Integer>> ll = new ArrayList<>();
        int arrlen = nums.length;
        if(arrlen < 3) return ll;
        Arrays.sort(nums);
        for(int i = 0;i < arrlen ;i++){
            if(nums[i] > 0) break;
            if(i > 0 && nums[i] == nums[i - 1]) continue;
            int j = i + 1,k = arrlen - 1;
            while(j < k){
                if(j > i + 1 && nums[j] == nums[j - 1]){
                    j++;
                    continue;
                }
                if(k < arrlen - 2 && nums[k] == nums[k + 1]){
                    k--;
                    continue;
                }
                int temp = nums[i] + nums[j] + nums[k];
                if(temp == 0) ll.add(Arrays.asList(nums[i],nums[j++],nums[k--]));
                else if(temp < 0) j++;
                else k--;
            }
        }
        return ll;
    }
    /*
        不需要用到集合，排序，双指针，去重
     */
}
