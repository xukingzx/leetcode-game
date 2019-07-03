package waitsolve;

public class MaxProduct_152 {
    /*public int maxProduct(int[] nums) {
        int[] dp = new int[nums.length];
        for(int i = 0;i < nums.length;i++){
            dp[i] = nums[i];
        }

        int start = 0;
        int preNegativePos = 0;
        boolean isNegative = false;
        if(nums[0] < 0) isNegative = true;
        for(int i = 1;i < nums.length;i++){
            if(nums[i] < 0 && isNegative == true) {
                if(preNegativePos == 0){
                    dp[i] = f(nums,preNegativePos,i);
                }
                else{
                    dp[i] = dp[preNegativePos - 1] * f(nums,preNegativePos,i);
                }
                isNegative = !isNegative;
            }
            else if(nums[i] > 0 && isNegative == true){
                dp[i] = f(nums,preNegativePos,i);
            }
            else if(nums[i] > 0 && isNegative == false){
                dp[i] = dp[i] * dp[i - 1];
            }
            else if(nums[i] < 0 && isNegative == false){
                isNegative = !isNegative;
            }
        }

        int maxNum = Integer.MIN_VALUE;
        for(int i = 0;i < dp.length;i++) {
            maxNum = Math.max(maxNum, dp[i]);
        }
        return maxNum;
    }
    private int f(int[] nums,int begin,int end){
        int sum = 1;
        for(int i = begin;i <= end;i++){
            sum = sum * nums[i];
        }
        return sum;
    }

     */

    public int maxProduct(int[] nums) {
        int max = nums[0], min = nums[0], res = nums[0];
        for(int i = 1; i < nums.length; i++){
            if(nums[i] < 0){
                int tmp = max;
                max = min;
                min = tmp;
            }
            max = Math.max(nums[i], max * nums[i]);
            min = Math.min(nums[i], min * nums[i]);
            res = Math.max(max, res);
        }
        return res;
    }

}
