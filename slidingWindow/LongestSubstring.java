package slidingWindow;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstring {

    public int lengthOfLongestSubstring(String s) {
        int max = 0;
        int left = 0;
        int right = 0;

        Set<Character> charset = new HashSet<>();

        while(right<s.length()){

            if(!charset.contains(s.charAt(right))){
                charset.add(s.charAt(right));
                max = Math.max(max, (right-left+1));
                right++;
            }else {
                charset.remove(s.charAt(left));
                left++;
            }

        }

        return max;
    }
}
