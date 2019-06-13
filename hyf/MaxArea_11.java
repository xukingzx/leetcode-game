package solution;

public class MaxArea_11 {
    public int maxArea_v1(int[] height) {
        int len = height.length;
        //if (len < 2) return 0;
        int max = 0;
        for(int i = 0;i < len;i++){
            for(int j = i + 1;j < len;j++){
                max = Math.max(max,Math.min(height[i],height[j])*(j - i));
            }
        }
        return max;
    }

    public int maxArea_v2(int[] height){
        int l = 0,r = height.length - 1,max = 0;
        while(l < r){
            max = Math.max(max,Math.min(height[l],height[r])*(r-l));
            if(height[l] > height[r])r--;
            else l++;
        }
        return max;
    }

}
