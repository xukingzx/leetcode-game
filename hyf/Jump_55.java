package waitSolve;

import java.util.Arrays;

public class Jump_55 {
    private int[] split(int[] nums,int k){
        int len = nums.length - k;
        int[] ret = new int[len];
        for(int i = 0;i < len;i++){
            ret[i] = nums[k++];
        }
        return ret;
    }
    private boolean jump_v1(int[] nums,int length){
        if(length <= 1) {
            return true;
        }
        int num = Math.min(nums[0],length-1);
        for(int i = 1;i <= num;i++){
            int newNums[] = split(nums,i);
            if(jump_v1(newNums,newNums.length)){
                return true;
            }
        }
        return false;
    }

    public boolean jump_v2(int position, int[] nums) {
        if (position == nums.length - 1) {
            return true;
        }
        int furthestJump = Math.min(position + nums[position], nums.length - 1);
        for (int nextPosition = position + 1; nextPosition <= furthestJump; nextPosition++) {
            if(jump_v2(nextPosition, nums)) {
                return true;
            }
        }
        return false;
    }


    enum Index {
        GOOD, BAD, UNKNOWN
    }

    Index[] memo;

    public boolean canJumpFromPosition(int position, int[] nums) {
        if (memo[position] != Index.UNKNOWN) {
            return memo[position] == Index.GOOD ? true : false;
        }

        int furthestJump = Math.min(position + nums[position], nums.length - 1);
        for (int nextPosition = position + 1; nextPosition <= furthestJump; nextPosition++) {
            if (canJumpFromPosition(nextPosition, nums)) {
                memo[position] = Index.GOOD;
                return true;
            }
        }
        memo[position] = Index.BAD;
        return false;
    }
    public boolean canJump(int[] nums) {
        memo = new Index[nums.length];
        for (int i = 0; i < memo.length; i++) {
            memo[i] = Index.UNKNOWN;
        }
        memo[memo.length - 1] = Index.GOOD;
        return canJumpFromPosition(0, nums);
    }

    /*public boolean canJump(int[] nums) {
        return jump_v1(nums,nums.length);
    }
     */

}
