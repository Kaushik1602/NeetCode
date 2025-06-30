package arraysAndHashing;

public class ProductOfArrayExceptSelf {

    public int[] productExceptSelf(int[] nums) {
        int[] output = new int[nums.length];
        int product = 1;
        int index = 0;
        int count = 0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==0){
                count++;
                index = i;
                continue;
            }
            product*=nums[i];
        }

        if(count==1){
            output[index] = product;
            return output;
        }else if(count>1){
            return output;
        }

        int i =0;
        for(int num:nums){
            output[i]=product/num;
            i++;
        }

        return output;
    }

    public int[] productExceptSelfWithoutDiv(int[] nums) {

        int[] output = new int[nums.length];
        int product = 1;
        output[0] = 1;
        for(int i=1;i<nums.length;i++){
            product *= nums[i-1];
            output[i] =product;
        }
        product = 1;
        for (int i = nums.length-2;i>=0;i--){
            product *= nums[i+1];
            output[i] = output[i]*product;
        }

        return output;
    }
}
