package arraysAndHashing;

import java.util.ArrayList;
import java.util.List;

public class EncodeDecodeStrings {

    public String encode(List<String> strs) {
        StringBuffer sb = new StringBuffer();
        if (strs.isEmpty()){
            return "";
        }
        for(String str : strs){
            sb.append(str.length());
            sb.append("#");
            sb.append(str);
        }

        return sb.toString();
    }

    public List<String> decode(String str) {
        if (str.isEmpty()){
            return new ArrayList<>();
        }
        List<String> result = new ArrayList<>();
        int i=0;
        //through iteration string only. -> more time
        while(i<str.length()){
            int j =i;
            while(str.charAt(j)!='#'){
                j++;
            }
            int length = Integer.valueOf(str.substring(i,j));
            result.add(str.substring(j+1, j+length+1));
            i=j+length+1;
        }

        //using Array.  -> more space
        /*String[] splitStrArr = str.split(",#");
        int length = Integer.parseInt(splitStrArr[0]);
        if (length==0 && splitStrArr.length==1){
            return List.of(new String[]{""});
        }
        for(int i=1;i<splitStrArr.length;i++){
            result.add(splitStrArr[i].substring(0,length));
            if(i==splitStrArr.length-1){
                continue;
            }
            length = Integer.valueOf(splitStrArr[i].substring(length));
        }
*/
        return result;
    }

}
