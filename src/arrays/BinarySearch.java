package arrays;

/**
 * Created by nikhandelwal on 12/10/2015.
 */
public class BinarySearch {


    public static boolean search(int [] nums, int start , int end, int k){

        if(start > end) return false;
        int mid = (start + end) /2;

        if(nums[mid]== k) return true;

        else if (nums[mid] > k) return search(nums, start, mid -1, k);
        else return search(nums, mid+1, end , k);
    }


    public static void main(String [] args){

        int nums [] = {1};
        System.out.println(search(nums, 0, nums.length-1, 1));
    }
}
