package solution;

import java.util.HashMap;

public class TwoSum_1 {
    public int[] twoSum_v1(int[] nums, int target) {
        int arrLen = nums.length;
        for(int i = 0;i < arrLen;i++){
            for(int j = i + 1;j < arrLen;j++){
                if(nums[i] + nums[j] == target)return new int[]{i,j};
            }
        }
        return new int[]{-1,-1};
    }
    /*
       最容易想到的一种解法
       时间复杂度O(N^2)
       空间复杂度O(1)
       执行用时 : 54 ms, 在Two Sum的Java提交中击败了33.62% 的用户
       内存消耗 : 37.1 MB, 在Two Sum的Java提交中击败了92.23% 的用户
     */

    public int[] twoSum_v2(int[] nums,int target){
        HashMap<Integer,Integer> m = new HashMap<>();
        for(int i = 0;i < nums.length;i++){
            m.put(nums[i],i);
        }

        for(int i = 0;i < nums.length;i++){
            if(m.containsKey(target - nums[i]) == true && m.get(target - nums[i]) != i){
                return new int[]{i,m.get(target-nums[i])};
            }
        }
        return new int[]{-1,-1};
    }
    /*
        时间复杂度O(N)
        空间复杂度O(N)
        执行用时 : 9 ms, 在Two Sum的Java提交中击败了76.84% 的用户
        内存消耗 : 38.3 MB, 在Two Sum的Java提交中击败了67.89% 的用户
     */

    public int[] twoSum_v2_1(int[] nums, int target) {
        HashMap<Integer,Integer> m = new HashMap<>();
        int len = nums.length;
        for(int i = 0;i < len;i++){
            m.put(nums[i],i);
        }

        for(int i = 0;i < len;i++){
            int value = target - nums[i];
            if(m.containsKey(value) == true && m.get(value) != i){
                return new int[]{i,m.get(value)};
            }
        }
        return new int[]{-1,-1};
        /*
            优化一下
            执行用时 : 8 ms, 在Two Sum的Java提交中击败了84.31% 的用户
            内存消耗 : 38 MB, 在Two Sum的Java提交中击败了77.05% 的用户
         */
    }
    public int[] twoSum_v3(int[] nums, int target){
        HashMap<Integer,Integer> m = new HashMap<>();
        for(int i = 0;i < nums.length;i++){
            if(m.size() == 0){
                m.put(nums[i],i);
            }
            else{
                int value = target - nums[i];
                if(m.containsKey(value) == true && m.get(value) != i){
                    return new int[] {i,m.get(value)};
                }
                m.put(nums[i],i);
            }
        }
        return new int[]{-1,-1};
    }
    /*
        复杂度与上一个相同，但是只遍历了一遍
        执行用时 : 7 ms, 在Two Sum的Java提交中击败了88.94% 的用户
        内存消耗 : 37.7 MB, 在Two Sum的Java提交中击败了84.78% 的用户
     */
}
