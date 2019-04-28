package xuking.algorithm;

import java.util.HashSet;
import java.util.Set;

public class MathQuestion {
    public static void main(String[] args) {
        System.out.println(isHappy(19));
    }

    /**
     * 202. Happy Number
     */
    public static boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        while (n != 1) {
            int sum = 0;
            while (n > 0) {
                sum += (n % 10) * (n % 10);
                n /= 10;
            }
            if (set.contains(sum)) {
                return false;
            }
            set.add(n = sum);
        }
        return true;
    }
}
