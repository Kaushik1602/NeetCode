package stack;

import java.util.Stack;

public class DailyTemperatures {
    public int[] dailyTemperaturesBruteForce(int[] temperatures) {    //30,38,30,36,35,40,28
        int[] result = new int[temperatures.length];        // 1  4  1  2  1  0  0
        for (int i=0; i<temperatures.length;i++){
            int count = 1;
            int j =i+1;
            while(j<temperatures.length && temperatures[i]>=temperatures[j]){
                count++;
                j++;
            }
            if(count==temperatures.length-i){
                count = 0;
            }
            result[i] = count;
        }

        return result;
    }

    public int[] dailyTemperatures(int[] temperatures) {
        int[] result = new int[temperatures.length];
        Stack<int[]> stack = new Stack<>();
        for (int i = 0; i < temperatures.length; i++) {
            int t = temperatures[i];
            while (!stack.isEmpty() && t > stack.peek()[0]) {
                int[] pair = stack.pop();
                result[pair[1]] = i - pair[1];
            }
            stack.push(new int[]{t, i});
        }

        return result;
    }

}
