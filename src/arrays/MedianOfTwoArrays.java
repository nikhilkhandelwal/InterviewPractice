package arrays;

/**
 * Created by nikhandelwal on 1/14/2016.
 */
public class MedianOfTwoArrays {



    public static int findMedian(int [] array1, int start1, int end1, int[] array2, int start2, int end2 ){

        int length = end1 -start1;

        if (length <= 0)
            return -1;

        if (length == 1)
            return (array1[0] + array2[0])/2;

        if (length == 2)
            return (Math.max(array1[0], array2[0]) + Math.min(array1[1], array2[1])) / 2;

        int med1 = getMedian(array1, start1, end1);
        int med2 = getMedian(array1, start1, end1);

        if(med1 == med2) return med1;

        if(med1 > med2 ){

            if (length %2 ==0)
                findMedian(array1,start1, (end1 -start1)/2-1, array2, (end2 -start2)/2  , end2);
        }

        else
            findMedian(array1,(end1 -start1)/2, end1, array2, start2, (end2 -start2)/2 );

        return 1;

    }

    static int getMedian(int [] array, int start, int end){


        int length =(end - start +1);

        if(length % 2 ==0 ) return (array[ length] +  array [length/2 -1]) ;
        else
            return array[length/2];
    }
}
