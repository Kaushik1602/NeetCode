package twoPointers;

public class ValidPalindrome {

    public boolean isPalindrome(String s) {
        s=s.toUpperCase();
        int left = 0;
        int right = s.length()-1;
        while(left<right){
            if(!checkAlphaNum(s.charAt(left))){
                left++;
            } else if (!checkAlphaNum(s.charAt(right))) {
                right--;
            } else if (s.charAt(left)!=s.charAt(right)) {
                return false;
            } else {
                left++;
                right--;
            }

        }
        return true;
    }

    public boolean checkAlphaNum(Character c){
        return ((c>='a' && c<='z') || (c>='A' && c<='Z') || (c>='0' && c<='9'));
    }
}
