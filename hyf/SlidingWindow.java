package waitsolve;

public class SlidingWindow {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int len = nums.length - k + 1;
        int[] ret = new int[len];
        for(int i = 0;i < len;i++){
            ret[i] = maxArray(nums,i,i + k - 1);
        }
        return ret;
    }

    private int maxArray(int[] nums,int left,int right){
        int ret = Integer.MIN_VALUE;
        for(int i = left;i <= right;i++){
            ret = Math.max(nums[i],ret);
        }
        return ret;
    }
}
