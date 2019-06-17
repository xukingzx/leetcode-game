package waitSolve;

import java.util.*;

public class MergeRange_56 {
    /*
        输入: [[1,3],[2,6],[8,10],[15,18]]
        输出: [[1,6],[8,10],[15,18]]
     */
    class MyComparator implements Comparator<int[]> {
        public int compare(int[] a,int[] b){
            if(a[0] < b[0]) return -1;
            else if(a[0] > b[0]) return 1;
            else return 0;
        }
    }

    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals,new MyComparator());
        int length = intervals.length;
        if(length == 0) return new int[0][0];
        int arrsize = 1;
        for(int i = 1;i < length;i++){
            if(intervals[i][0] <= intervals[arrsize-1][1])
                if(intervals[i][1] > intervals[arrsize-1][1])
                    intervals[arrsize-1][1] = intervals[i][1];
                else
                    continue;
            else
                intervals[arrsize++] = intervals[i];
        }
        int[][] ret = new int[arrsize][2];
        for(int i = 0;i < arrsize;i++){
            ret[i] = intervals[i];
        }
        return ret;
    }

    class Interval{
        int start;
        int end;
        public  Interval(int a,int b){
            this.start = a;
            this.end = b;
        }

    }
    class IntervalComparator implements Comparator<Interval> {
        @Override
        public int compare(Interval a, Interval b) {
            return a.start < b.start ? -1 : a.start == b.start ? 0 : 1;
        }
    }

    public List<Interval> merge(List<Interval> intervals) {
        Collections.sort(intervals, new IntervalComparator());

        LinkedList<Interval> merged = new LinkedList<Interval>();
        for (Interval interval : intervals) {
            // if the list of merged intervals is empty or if the current
            // interval does not overlap with the previous, simply append it.
            if (merged.isEmpty() || merged.getLast().end < interval.start) {
                merged.add(interval);
            }
            // otherwise, there is overlap, so we merge the current and previous
            // intervals.
            else {
                merged.getLast().end = Math.max(merged.getLast().end, interval.end);
            }
        }

        return merged;
    }

}
