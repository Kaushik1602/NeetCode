package arraysAndHashing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TopKFrequentElements {
    public int[] topKFrequent(int[] nums, int k) {
        int[] result = new int[k];
        Map<Integer,Integer> freqMap = new HashMap<>();
        for(int num:nums){
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }

        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(freqMap.entrySet());

        list.sort(Map.Entry.<Integer, Integer>comparingByValue().reversed());
        int i=0;
        for (Map.Entry key : list) {
            if (i==k){
                break;
            }
            result[i] = (Integer)key.getKey();
            i++;
        }

        return result;
    }
}
