package solution;

import java.util.Arrays;

public class SearchRange_34 {
    public int[] searchRange(int[] nums, int target) {
        int index,l,r;
        if((index = Arrays.binarySearch(nums,target)) < 0){
            return new int[]{-1,-1};
        }
        else{
            l = r = index;
            while(l >= 0){
                if(nums[l] == nums[index])l--;
                else break;
            }
            while(r < nums.length){
                if(nums[r] == nums[index])r++;
                else break;
            }
        }
        return new int[]{l+1,r-1};
    }
}
