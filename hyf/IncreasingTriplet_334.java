package waitsolve;

public class IncreasingTriplet_334 {
    public boolean increasingTriplet(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = 1;
        for(int i = 1;i < nums.length;i++){
            dp[i] = 1;
            for(int j = 0;j < i;j++){
                if(nums[i] > nums[j]){
                    dp[i] = Math.max(dp[j] + 1,dp[i]);
                }
            }
        }
        for(int i = 0;i < dp.length;i++){
            if(dp[i] >= 3) return true;
        }
        return false;
    }

    public boolean increasingTriplet_v2(int[] nums) {
        int one = Integer.MAX_VALUE;
        int two = Integer.MAX_VALUE;

        for (int n : nums) {
            if (n <= one) {
                one = n;
            } else if (n <= two) {
                two = n;
            } else {
                return true;
            }
        }

        return false;
    }
}
