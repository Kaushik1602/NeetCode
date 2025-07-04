package twoPointers;

import java.util.*;

public class ThreeSum {

    public List<List<Integer>> threeSumBruteForce(int[] nums) {
        List<List<Integer>> resultList = new ArrayList<>();
        //-1,0,1,2,-1,-4
        //(-1+0),(-1+1),(-1+2),(-1-1),(-1-4)
        //((-1+0)+1,(-1+0)+2,(-1+0)-1,(-1+0-4)),((-1+1)+0,(-1+1)+2,(-1+1)-1,(-1+1)-4)),(-1+2),(-1-1),(-1-4)
        Arrays.sort(nums);

        for(int i=0;i<nums.length;i++){
            for(int j=i+1;j<nums.length;j++){
                for(int k=j+1;k<nums.length;k++){
                    if(nums[i]+nums[j]+nums[k]==0){
                        List<Integer> result = new ArrayList<>();
                        result.add(nums[i]);
                        result.add(nums[j]);
                        result.add(nums[k]);
                        resultList.remove(result);
                        resultList.add(result);
                    }
                }
            }
        }

        return resultList;
    }

    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> resultList = new HashSet<>();

        Arrays.sort(nums);

        for(int i=0;i<nums.length;i++){
            int left = i+1;
            int right = nums.length-1;
            while(left<right){
                if (-nums[i]==nums[left]+nums[right]){
                    List<Integer> result = new ArrayList<>();
                    result.add(nums[i]);
                    result.add(nums[left]);
                    result.add(nums[right]);
                    resultList.add(result);
                    left++;
                    right--;
                }else if (-nums[i]<nums[left]+nums[right]){
                    right--;
                }else {
                    left++;
                }
            }
        }

        return new ArrayList<>(resultList);
    }
}
