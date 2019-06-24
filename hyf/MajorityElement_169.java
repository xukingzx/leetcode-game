package waitSolve;

public class MajorityElement_169 {
    private int countInRange(int[] nums, int num, int lo, int hi) {
        int count = 0;
        for (int i = lo; i <= hi; i++) {
            if (nums[i] == num) {
                count++;
            }
        }
        return count;
    }

    private int majorityEleme(int[] nums, int lo, int hi) {
        if (lo == hi) {
            return nums[lo];
        }
        int mid = (hi-lo)/2 + lo;
        int left = majorityEleme(nums, lo, mid);
        int right = majorityEleme(nums, mid+1, hi);
        if (left == right) {
            return left;
        }
        int leftCount = countInRange(nums, left, lo, hi);
        int rightCount = countInRange(nums, right, lo, hi);
        return leftCount > rightCount ? left : right;
    }
    public int majorityElement(int[] nums) {
        return majorityEleme(nums, 0, nums.length-1);
    }

}
