package arraysAndHashing;

import java.util.*;
import java.util.stream.Collectors;

public class LongestConsecutiveSequence {

    public int longestConsecutive(int[] nums) {
        int result = 0;

        Set<Integer> set = new HashSet<>();
        for (int num:nums){
            set.add(num);
        }

        for (int num:nums){
            int count = 0;
            if (set.contains(num-1)){
                continue;
            }
            int curr = num;
            while (set.contains(curr)) {
                count++;
                curr++;
            }
            result = Math.max(result,count);
        }
        return result;
    }

}
