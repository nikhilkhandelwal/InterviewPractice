package arrays;

/**
 * Created by nikhandelwal on 1/14/2016.
 */
public class PivotedBinarySearch {


    public static void main(String [] args){

        int arr1[] = {4,5, 6, 7, 8, 9, 1, 2, 3};

        System.out.println(findPivot(arr1,0,8));
    }

    public static int findPivot(int arr[], int low, int high)
    {
        // base cases
        if (high < low)  return -1;
        if (high == low) return low;

        int mid = (low + high)/2;   /*low + (high - low)/2;*/
        if (arr[mid] > arr[mid + 1])
            return mid;
        if (arr[mid] < arr[mid - 1])
            return (mid-1);
        if (arr[low] >= arr[mid])
            return findPivot(arr, low, mid-1);
        return findPivot(arr, mid + 1, high);
    }
}
