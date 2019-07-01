package waitsolve;

public class RotateArray {
    public void rotate(int[] nums, int k) {
        if(nums.length <= 1) return;
        k = k % nums.length;
        for(int i = 0;i < nums.length/2;i++){
            swap(nums,i,nums.length - 1 - i);
        }
        for(int i = 0;i < k / 2;i++){
            swap(nums,i,k - i - 1);
        }
        for(int left = k,right = nums.length - 1;left < right;left++,right--){
            swap(nums,left,right);
        }
    }
    private void swap(int[] nums,int left,int right){
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }
}
