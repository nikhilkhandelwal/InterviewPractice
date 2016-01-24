package arrays;

/**
 * Created by nikhandelwal on 1/19/2016.
 */
public class MajorityNumber {

    public static void main(String [] args){


    }

    public static boolean findMajorityElement(int [] arr, int x){

        /* Find first occurence of the element in arr */
        
        int startingIndex = firstOcccurence(arr, x, 0 , arr.length -1);

        if (startingIndex == -1)
            return false;

        if( (startingIndex + arr.length/2 <= arr.length-1 ) && arr[ startingIndex + arr.length/2 ]== x)
            return true;

        return false;
    }

    private static int firstOcccurence(int[] arr, int x, int low, int high) {

        if(high > low) {
            int mid = (low + high) / 2;

            if (arr[mid] == x && arr[mid - 1] < x) return mid;

            else if (x > arr[mid])
                return firstOcccurence(arr, x, mid + 1, high);
            else
                return firstOcccurence(arr, x, low, mid - 1);
        }
        return -1;

    }
}
