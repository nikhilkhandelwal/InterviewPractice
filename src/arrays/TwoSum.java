package arrays;

/**
 * Created by nikhandelwal on 12/1/2015.
 */
public class TwoSum {


    public static int binarySearch(int [] array, int element, int start, int end){

        if (start > end)
            return -1;
        int mid  = (start +end) /2;
        if(array[mid] == element)
            return mid;
        else if(element > array[mid]){
            return binarySearch(array, element, mid +1, end);
        }
        else{
            return binarySearch(array, element, start, mid-1);
        }
    }

    public static int [] quickSort(int [] array , int start, int end){

        if(start<end){
            int p = partition(array , start, end);
            quickSort(array, start , p-1);
            quickSort(array, p+1,end);
        }
        return array;

    }

    public static int partition(int [] array, int start, int end){
        int pivot = array[end];
        int low = start;

        for (int i = start ; i< end ; i++){
            if(array[i] <= pivot){
                swap(array,i,low);
                low=low+1;
            }
        }

        swap(array,low,end);

        return low;

    }

    public static void swap(int [] array, int i, int j){
        int temp = array[i];
        array[i] = array[j];
        array[j]=temp;
    }

    public static void twoSum(int [] array, int sum){

        quickSort(array,0,array.length-1);
        //System.out.println(array.)
        for(int i = 0; i <array.length; i++) {
            int index = binarySearch(array, Math.abs(array[i] - sum), 0, array.length - 1);
            if (index != -1) {
                System.out.println("index 1: " + i + "index 2 :" + index);
                break;
            }
        }
    }
    public static void main(String args[]) {

            int [] array = {1,9,2,3,5,7};
            twoSum(array, 11);


    }
}
