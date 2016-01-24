package arrays;

import java.util.PriorityQueue;

/**
 * Created by nikhandelwal on 1/21/2016.
 */
public class KthLargestHeap {


    public static int findKthLargest(int[] nums, int k) {

        PriorityQueue<Integer> heap =  new PriorityQueue<>(k);

        for( int i : nums){

            heap.add(i);
        }

        for(int i: heap)
            System.out.println(i);
        return heap.poll();
    }


    public static void main(String [] args){

        int nums [] = {2,1,6,8,9};
        int n = nums.length;
        System.out.println(findKthLargest(nums, 2));

    }
}
