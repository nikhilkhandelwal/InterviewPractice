package arrays;

import java.util.Arrays;

/**
 * Created by nikhandelwal on 12/28/2015.
 */
public class ThreeSum {

    public static void main(String [] args){

        int[] array = {0,3,4,1,6,2,8,5};

        threeSumProblem(array, 8);

    }

    public static void threeSumProblem (int[] a, int sum)
    {
        Arrays.sort(a);
        for (int i = 0; i< a.length-2 ; i++){

            int j = i+1;int k = a.length -1;
            while(j<k){

                if(a[i]+a[j]+a[k] == sum){

                    System.out.printf("Triplet is %d, %d, %d", a[i], a[j], a[k]);
                   // return;
                    j++;k--;
                }
                else if(a[j] + a[k] < sum - a[i]){
                    j++;
                }
                else if(a[j] + a[k] > sum - a[i]){
                    k--;
                }
            }
        }
    }

}
