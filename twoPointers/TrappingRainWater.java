package twoPointers;

public class TrappingRainWater {
    public int trap(int[] height) {
        int result = 0;
        int left = 0;
        int right = 0;
        int[] leftMax = new int[height.length];
        int[] rightMax = new int[height.length];
        for(int i =0;i<height.length;i++){
            if(height[i]>left){
                left = height[i];
            }
            leftMax[i] = left;
            if(height[height.length-1-i]>right){
                right = height[height.length-1-i];
            }
            rightMax[height.length-1-i] = right;
        }

        for(int i =0 ;i<height.length;i++){
            result += Math.min(leftMax[i],rightMax[i]) - height[i];
        }
        return result;
    }

    public int trapTwoPointer(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }

        int l = 0, r = height.length - 1;
        int leftMax = height[l], rightMax = height[r];
        int res = 0;
        while (l < r) {
            if (leftMax < rightMax) {
                l++;
                leftMax = Math.max(leftMax, height[l]);
                res += leftMax - height[l];
            } else {
                r--;
                rightMax = Math.max(rightMax, height[r]);
                res += rightMax - height[r];
            }
        }
        return res;
    }
}
