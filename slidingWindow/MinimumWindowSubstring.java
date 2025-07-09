package slidingWindow;

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring {

    public String minWindowN(String s, String t) {
        if (t.isEmpty())
            return "";

        Map<Character, Integer> countT = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();

        for (char c : t.toCharArray()) {
            countT.put(c, countT.getOrDefault(c, 0) + 1);
        }

        int have = 0, need = countT.size();
        int[] res = {-1, -1};
        int resLen = Integer.MAX_VALUE;
        int l = 0;

        for(int r =0; r<s.length();r++){
            char c = s.charAt(r);
            window.put(c, window.getOrDefault(c,0)+1);

            if (countT.containsKey(c) && (countT.get(c).equals(window.get(c)))){
                have++;
            }

            while (have==need){
                if(r-l+1 <resLen){
                    resLen = r-l+1;
                    res[0] = l;
                    res[1] = r;
                }

                char leftC = s.charAt(l);
                window.put(leftC, window.get(leftC)-1);

                if (countT.containsKey(leftC) && countT.get(leftC)>window.get(leftC)){
                    have--;
                }
                l++;
            }
        }

        return resLen == Integer.MAX_VALUE ? "" : s.substring(res[0], res[1] + 1);
    }

    public String minWindow(String s, String t) {
        if (t.isEmpty())
            return "";

        Map<Character, Integer> countT = new HashMap<>();

        for (char c : t.toCharArray()) {
            countT.put(c, countT.getOrDefault(c, 0) + 1);
        }

        int count = t.length();
        String result = "";
        int l = 0;
        int resLen = Integer.MAX_VALUE;
        for(int r =0; r<s.length();r++){
            char c = s.charAt(r);

            if (countT.containsKey(c)){
                countT.put(c,countT.get(c)-1);
                if(countT.get(c)>=0){
                    count--;
                }
            }

            while (count==0){
                if(r-l+1 <resLen){
                    result = s.substring(l,r+1);
                    resLen = r-l+1;
                }

                char leftC = s.charAt(l);

                if (countT.containsKey(leftC)){
                    countT.put(leftC,countT.get(leftC)+1);
                    if (countT.get(leftC) > 0) {
                        count++;
                    }
                }
                l++;
            }
        }

        return result;
    }
}
