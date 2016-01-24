package arrays;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by nikhandelwal on 10/28/2015.
 */
public class ArrayTesy {



    public static int partition(int [] array , int start, int end){


        int pivot = array [end];
        int i = start;
        for(int j=start; j < end ; j++) {
            if (array[j] <= pivot) {
                swap(array, i, j);
                i = i + 1;
            }
        }

        swap(array,i,end);

        return i;
    }

    public static int [] quickSort(int array[], int start, int end){

        if(start<end){
            int p = partition(array , start, end);
            quickSort(array, start , p-1);
            quickSort(array, p+1,end);
        }
        return array;
    }

    public static void swap(int[] array, int i, int j ){

        int temp = array[i];
        array[i] = array[j];
        array[j]=temp;
    }

    int kLargestNumber(int [] array){




        return 0;

    }


    public static int cPartition(char [] array , int start, int end){


        char pivot = array [end];
        int i = start;
        for(int j=start; j < end ; j++) {
            if (array[j] <= pivot) {
                cSwap(array, i, j);
                i = i + 1;
            }
        }

        cSwap(array, i, end);

        return i;
    }

    public static char [] cQuickSort(char array[], int start, int end){

        if(start<end){
            int p = cPartition(array, start, end);
            cQuickSort(array, start, p - 1);
            cQuickSort(array, p + 1, end);
        }
        return array;
    }

    public static void cSwap(char[] array, int i, int j ){

        char temp = array[i];
        array[i] = array[j];
        array[j]=temp;
    }


    public static void main(String [] args){

        int [] array = {3,4,1,6,2,8,5};


        String input = "nikhil";
        char [] cArray = input.toCharArray();

        StringBuilder finalString = new StringBuilder();
        for(char i : cQuickSort(cArray, 0, 5))
        {

            finalString.append(i);
        }

        System.out.println(finalString);
    }

    public List<List<Integer>> threeSum(int[] num) {
        Arrays.sort(num);
        List<List<Integer>> res = new LinkedList<>();
        for (int i = 0; i < num.length-2; i++) {
            if (i == 0 || (i > 0 && num[i] != num[i-1])) {
                int lo = i+1, hi = num.length-1, sum = 0 - num[i];
                while (lo < hi) {
                    if (num[lo] + num[hi] == sum) {
                        res.add(Arrays.asList(num[i], num[lo], num[hi]));
                        while (lo < hi && num[lo] == num[lo+1]) lo++;
                        while (lo < hi && num[hi] == num[hi-1]) hi--;
                        lo++; hi--;
                    } else if (num[lo] + num[hi] < sum) lo++;
                    else hi--;
                }
            }
        }
        return res;
    }


}
