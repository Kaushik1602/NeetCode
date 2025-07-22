package stack;

import java.util.Stack;

public class LargestRectangleInHistogram {
    public int largestRectangleAreaBruteForce(int[] heights) {
        int area = 0;
        for(int i = 0;i<heights.length;i++ ){
            int countL = 0;
            int countR = 0;
            while((i-countL)>=0 && heights[i]<=heights[i-countL]){
                countL++;
            }
            while((i+countR)<heights.length && heights[i]<=heights[i+countR]){
                countR++;
            }
            int width = countL+countR-1;
            area = Math.max(width*heights[i], area);
        }
        return area;
    }

    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int[] leftMost = new int[n];
        int[] rightMost = new int[n];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            leftMost[i] = -1;
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                stack.pop();
            }
            if (!stack.isEmpty()) {
                leftMost[i] = stack.peek();
            }
            stack.push(i);
        }

        stack.clear();
        for (int i = n - 1; i >= 0; i--) {
            rightMost[i] = n;
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                stack.pop();
            }
            if (!stack.isEmpty()) {
                rightMost[i] = stack.peek();
            }
            stack.push(i);
        }

        int maxArea = 0;
        for (int i = 0; i < n; i++) {
            leftMost[i] += 1;
            rightMost[i] -= 1;
            maxArea = Math.max(maxArea, heights[i] * (rightMost[i] - leftMost[i] + 1));
        }
        return maxArea;
    }

    public int largestRectangleAreaOnePass(int[] heights) {
        int maxArea = 0;
        Stack<int[]> stack = new Stack<>(); // pair: (index, height)

        for (int i = 0; i < heights.length; i++) {
            int start = i;
            while (!stack.isEmpty() && stack.peek()[1] > heights[i]) {
                int[] top = stack.pop();
                int index = top[0];
                int height = top[1];
                maxArea = Math.max(maxArea, height * (i - index));
                start = index;
            }
            stack.push(new int[]{start, heights[i]});
        }

        for (int[] pair : stack) {
            int index = pair[0];
            int height = pair[1];
            maxArea = Math.max(maxArea, height * (heights.length - index));
        }
        return maxArea;
    }
}
