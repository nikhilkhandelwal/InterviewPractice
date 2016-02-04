package arrays;

/**
 * Created by nikhandelwal on 1/31/2016.
 */
public class LongestIncreasingSubsequence {

    public static int lis(int [] arr ){

        int [] lis = {1,1,1,1,1,1,1,1};

        for(int i =0; i < arr.length ; i++){

            for(int j = 0 ; j < i; j++){
                if(arr[i] > arr[j] && lis[i] < lis[j] +1){
                    lis[i] = lis[j]+1;
                }
            }
        }

        int max = Integer.MIN_VALUE;
        for (int i : lis){
            max = i > max ? i : max;
        }

        return max;
    }

    public static void main(String args[]){
        int arr[] = { 10, 22, 33, 21, 50, 41, 60 };

        System.out.println(lis(arr));
    }


}
