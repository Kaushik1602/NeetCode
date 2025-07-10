package slidingWindow;

import java.util.*;

public class SlidingWindowMaximum {
    public int[] maxSlidingWindowQueue(int[] nums, int k) {
        int n = nums.length;
        int[] output = new int[n - k + 1];
        Deque<Integer> q = new LinkedList<>();
        int l = 0, r = 0;

        while (r < n) {
            while (!q.isEmpty() && nums[q.getLast()] < nums[r]) {
                q.removeLast();
            }
            q.addLast(r);

            if (l > q.getFirst()) {
                q.removeFirst();
            }

            if ((r + 1) >= k) {
                output[l] = nums[q.getFirst()];
                l++;
            }
            r++;
        }

        return output;
    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] maxArr = new int[nums.length-k+1];

        for (int i=0;i<nums.length-k+1;i++){
            int max = Integer.MIN_VALUE;
            int l = 0;
            while (l<k){
                max = Math.max(max,nums[i+l]);
                l++;
            }
            maxArr[i] = max;
        }
        return maxArr;
    }

}
