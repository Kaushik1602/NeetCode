package slidingWindow;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PermutationInString {
    public boolean checkInclusionBruteForce(String s1, String s2) {
        if(s1.length()>s2.length()){
            return false;
        }
        char[] s1Arr = s1.toCharArray();
        Arrays.sort(s1Arr);
        String sortedS1 = new String(s1Arr);
        int left = 0;
        int right = s1.length()-1;
        while(right<s2.length()){
            char[] s2Arr = s2.substring(left,right+1).toCharArray();
            Arrays.sort(s2Arr);
            String sortedS2 = new String(s2Arr);
            if(sortedS1.equalsIgnoreCase(sortedS2)){
                return true;
            }
            left++;
            right++;

        }

        return false;
    }

    public boolean checkInclusion(String s1, String s2) {
        if(s1.length()>s2.length()){
            return false;
        }
        int[] s1Arr = new int[26];
        int[] s2Arr = new int[26];
        int left = 0;
        int right = s1.length();

        for(char c:s1.toCharArray()){
            s1Arr[c-'a']++;
        }
        for(int i=0;i<s2.length();i++){
            if(i<right){
                s2Arr[s2.charAt(i)-'a']++;
            }else{
                if (Arrays.equals(s1Arr, s2Arr)){
                    break;
                }
                s2Arr = new int[26];
                i=left;
                left++;
                right++;
            }
        }
        return Arrays.equals(s1Arr, s2Arr);
    }
}
