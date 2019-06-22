package waitSolve;

public class MyPow {
    public double myPow(double x, int n) {
        if(n < 0){
            n = -n;
            x = 1/x;
        }
        double ans = 1;
        double temp = x;
        while(n > 0){
            if(n % 2 == 1){
                ans = ans * temp;
            }
            temp = temp * temp;
            n = n / 2;
        }
        return ans;
    }
}
