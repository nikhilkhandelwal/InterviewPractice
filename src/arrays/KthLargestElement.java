package arrays;

/**
 * Created by nikhandelwal on 12/7/2015.
 */
public class KthLargestElement {


    public static int partition(int[] nums, int start, int end, int pos){

        int pivot = nums[end];
        int k =start;
        for (int i = start; i < end ; i++){
            if(nums[i] < pivot){
                swap(nums, i, k);
                k++;
            }
            swap(nums,k,end);
        }

        int m = k - start + 1;

        // pivot is the one!
        if (m == pos)     return k;
            // pivot is too big, so it must be on the left
        else if (m > pos) return partition(nums, start, k - 1, pos);
            // pivot is too small, so it must be on the right
        else            return partition(nums, k + 1, end, pos - m);

    }

    public static void swap(int[] array, int i, int j ){

        int temp = array[i];
        array[i] = array[j];
        array[j]=temp;
    }


    public static int findKthLargest(int[] nums, int start, int end, int k) {

        int pos = partition(nums, start, end, k);

        return nums[pos];

    }


    public static void main(String [] args){

        int nums [] = {2,1,6,8,9};
        int n = nums.length;
        System.out.println(findKthLargest(nums, 0 , nums.length-1, nums.length - 5));

    }
}
