package slidingWindow;

import java.util.HashMap;
import java.util.Map;

public class LongestRepeatingCharacterReplacement {
    public int characterReplacement(String s, int k) {
        int result = 0;
        Map<Character, Integer> charCountMap = new HashMap<>();
        int left = 0;
        int maxf = 0;
        for (int r = 0; r < s.length(); r++) {
            charCountMap.put(s.charAt(r), charCountMap.getOrDefault(s.charAt(r),0)+1);
            maxf = Math.max(maxf, charCountMap.get(s.charAt(r)));
            while ((r - left + 1) - maxf > k) {
                charCountMap.put(s.charAt(left), charCountMap.get(s.charAt(left)) - 1);
                left++;
            }
            result = Math.max(result, r - left + 1);
        }

        return result;
    }
}
