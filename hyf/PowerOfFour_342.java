package solution;

public class PowerOfFour_342 {
    public boolean isPowerOfFour_v1(int num) {
        int k = 1;
        int i = 1;
        while(Math.pow(k, 4) < num) k++;
        if(Math.pow(k,4) == num){
            return true;
        }
        return false;
    }
    public boolean isPowerOfFour_v2(int num) {
        return num > 0 && (num & num - 1) == 0 && (num & 0x5555555) == num;
    }
}
