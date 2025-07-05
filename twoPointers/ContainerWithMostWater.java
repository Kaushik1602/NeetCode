package twoPointers;

public class ContainerWithMostWater {
    public int maxArea(int[] heights) {
        int max = 0;
        int left = 0;
        int right = heights.length-1;
        while(left<right){
            int height = Math.min(heights[left],heights[right]);
            int length = right-left;
            int area = height*length;
            max = Math.max(max,area);
            if (heights[left]>heights[right]){
                right--;
            }else {
                left++;
            }
        }
        return max;
    }
}
