package solution;

import java.util.Arrays;
public class NextPermutation_31 {
    public void nextPermutation(int[] nums) {
        boolean isDesc = true;
        for(int i = nums.length - 1;i > 0;i--){
            if(nums[i - 1] < nums[i]){
                int index = i,min = nums[i];
                for(int j = i;j < nums.length;j++){
                    //在右边找一个最小的而且比nums[i-1]大的
                    if(min > nums[j] && nums[j] > nums[i-1]){
                        min = nums[j];
                        index = j;
                        //break;
                    }
                }
                swap(nums,i-1,index);
                Arrays.sort(nums,i,nums.length);
                isDesc = false;
                break;
            }
        }
        if(isDesc == true) Arrays.sort(nums);
    }
    private void swap(int nums[],int a,int b){
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}
