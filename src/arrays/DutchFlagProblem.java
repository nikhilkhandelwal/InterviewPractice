package arrays;

/**
 * Created by nikhandelwal on 12/28/2015.
 */
public class DutchFlagProblem {

    public static void main(String[] args) {

        int[] array = {0,1,0,0,2,1,2,2,1};

        sortDutchFlag(array);
        for(int i: array){
            System.out.println(i);
        }


    }

    public static void sortDutchFlag(int [] nums) {
        int start = 0; int end = nums.length -1;
        for(int i = 0; i< nums.length;i++ ){
            if(nums[i]<1){
                swap(nums,start,i);
                start++;
            }
        }
        for(int i = start; i< nums.length;i++ ){
            if(nums[i]>1){
                swap(nums,end,i);
                end--;
            }
        }
    }

    public static void swap(int[] array, int i, int j ){

        int temp = array[i];
        array[i] = array[j];
        array[j]=temp;
    }
}