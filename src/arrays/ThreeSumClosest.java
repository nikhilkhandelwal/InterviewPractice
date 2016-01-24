package arrays;

import java.util.Arrays;
import java.util.HashSet;

/**
 * Created by nikhandelwal on 12/28/2015.
 */
public class ThreeSumClosest {

    public static void main(String [] args){

        int[] array = {0,1,2};

        System.out.println(threeSumProblem(array, 3));

    }

    public static int threeSumProblem (int[] nums, int target)
    {
        Arrays.sort(nums);
        int min = Integer.MAX_VALUE;

       int finalSum = 0;
        for (int i = 0; i< nums.length-2 ; i++){

            int j = i+1;int k = nums.length -1;
            while(j<k){

                if(Math.abs(nums[i]+nums[j]+nums[k] - target) < min) {
                    min = Math.abs(nums[i] + nums[j] + nums[k]- target)  ;
                    finalSum = nums[i] + nums[j] + nums[k];

                }

                if(nums[j] + nums[k] < target - nums[i]){
                    j++;
                }
                else if(nums[j] + nums[k] > target - nums[i]){
                    k--;
                }
                else{
                    j++;k--;
                }
            }
        }

        return finalSum;
    }

}
