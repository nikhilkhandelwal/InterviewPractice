package arrays;

/**
 * Created by nikhandelwal on 1/23/2016.
 */
public class SmallestNumberKDigits {

    public static int smallestNumberKDigits(String number, int k){

        if(number.length()==k) return Integer.parseInt(number);
        if(number.length() <k) return -1;
        char []  num = number.toCharArray();
        StringBuilder result  =  new StringBuilder();
        int start =0;
        int end = num.length-1;
        int count  = k;
        for(; start<=end && result.length() <k;){
            int length = end -start +1;
            if(length > count-1) {
                int index = findSmallestDigit(num, start, end - (count-1));
                result = result.append(num[index]);
                start = index +1;
                count--;
            }

        }

        return Integer.parseInt(result.toString());
    }

    public static int findSmallestDigit(char [] nums , int start, int end){

        int smallest = nums[start];
        int index=start;
        for(int i = start; i <=end; i++){
            if(nums[i] < smallest){
            index = i;
            smallest = nums[i];
            }

        }

        return index;
    }

    public static void main( String [] args){

        System.out.println(smallestNumberKDigits("12345", 1));
    }
}
