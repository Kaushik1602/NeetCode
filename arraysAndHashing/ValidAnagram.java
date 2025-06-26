package arraysAndHashing;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class ValidAnagram {

    public boolean isAnagram(String s, String t) {

        if(s.length()!=t.length()){
            return false;
        }

        Map<Character,Integer> sCharCount = new HashMap<>();
        Map<Character,Integer> tCharCount = new HashMap<>();

        for(int i=0;i<s.length();i++){
            if (sCharCount.containsKey(s.charAt(i))){
                sCharCount.put(s.charAt(i),sCharCount.get(s.charAt(i))+1);
            }else {
                sCharCount.put(s.charAt(i),1);
            }

            if (tCharCount.containsKey(t.charAt(i))){
                tCharCount.put(t.charAt(i),tCharCount.get(t.charAt(i))+1);
            }else {
                tCharCount.put(t.charAt(i), 1);
            }
        }

        return sCharCount.equals(tCharCount);
    }

}
