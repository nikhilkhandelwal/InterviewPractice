package arrays;

/**
 * Created by nikhandelwal on 1/14/2016.
 */
public class MaximumSumSubarray {


    public static void main(String [] args){

        int aray [] = { 1,3,5,-1,2,-9,4,1,1};

        int maxTillNow = aray[0];
        int maxUsingThis = aray[0];
        for(int i = 1; i< aray.length; i++){
            maxUsingThis = Math.max(maxUsingThis+aray[i] , aray[i]);
            maxTillNow = Math.max(maxTillNow, maxUsingThis);
        }
    }


}
