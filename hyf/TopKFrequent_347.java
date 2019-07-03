package waitsolve;

import java.util.*;

class Sort implements Comparator<int[]> {
    public int compare(int[] a,int b[]){
        return b[0] - a[0];
    }
}
public class TopKFrequent_347 {
    public List<Integer> topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> hm = new HashMap<>();
        for(int i = 0;i < nums.length;i++){
            if(hm.containsKey(nums[i]) == true){
                hm.put(nums[i],hm.get(nums[i]) + 1);
            }
            else{
                hm.put(nums[i],1);
            }
        }

        int mSize = hm.size();
        int[][] s = new int[mSize][2];
        int index = 0;
        for(Integer key : hm.keySet()){
            s[index][1] = key;
            s[index][0] = hm.get(key);
            index++;
        }
        Arrays.sort(s,new Sort());

        List<Integer> ret = new ArrayList<>();
        for(int i = 0;i < k;i++){
            ret.add(s[i][1]);
        }
        return ret;
    }

    public List<Integer> topKFrequent_v2(int[] nums, int k) {
        // 使用字典，统计每个元素出现的次数，元素为键，元素出现的次数为值
        HashMap<Integer,Integer> map = new HashMap();
        for(int num : nums){
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }
        // 遍历map，用最小堆保存频率最大的k个元素
        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b) {
                return map.get(a) - map.get(b);
            }
        });
        for (Integer key : map.keySet()) {
            if (pq.size() < k) {
                pq.add(key);
            } else if (map.get(key) > map.get(pq.peek())) {
                pq.remove();
                pq.add(key);
            }
        }
        // 取出最小堆中的元素
        List<Integer> res = new ArrayList<>();
        while (!pq.isEmpty()) {
            res.add(pq.remove());
        }
        return res;
    }
}
