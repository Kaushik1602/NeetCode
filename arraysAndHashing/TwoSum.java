package arraysAndHashing;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        Map<Integer,Integer> valueIndexMap = new HashMap<>();

        for(int i=0; i<nums.length;i++){
            int difference = target - nums[i];
            if (valueIndexMap.containsKey(difference)) {
                result[0]=valueIndexMap.get(difference);
                result[1]=i;
                return result;
            }else{
                valueIndexMap.put(nums[i],i);
            }
        }

        return result;
    }

}
