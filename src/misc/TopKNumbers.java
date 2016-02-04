package misc;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by nikhandelwal on 1/28/2016.
 */
public class TopKNumbers {

     public static PriorityQueue<Item> getTopK(Item [] numbers, int k){

         PriorityQueue<Item> heap = new PriorityQueue<>(k, new Comparator<Item>() {
             @Override
             public int compare(Item o1, Item o2) {
                 if(o1.val == o2.val)
                     return 0;
                 if(o1.val > o2.val)
                     return 1;
                 else
                     return -1;
             }
         });



         for(int i =0 ;i < numbers.length; i++){

             if(heap.size() < k ){
                 heap.add(numbers[i]);
             }
             else
             {
                 if(numbers[i].val > heap.peek().val) {
                      heap.poll();
                     heap.add(numbers[i]);
                 }
             }
         }

         return heap;

     }

    public static void main(String [] args){

        Item [] nums = { new Item(1), new Item(90), new Item (6),new Item (12),new Item (21)};

        for(Item i :  getTopK(nums, 2)){
            System.out.println(i.val);
        }
    }

    private static class Item{

        int val ;
        public Item(int val){

            this.val = val;
        }
    }
}
