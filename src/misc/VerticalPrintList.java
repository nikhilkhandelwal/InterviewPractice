package misc;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by nikhandelwal on 1/3/2016.
 */
public class VerticalPrintList {

    public static void main(String[] args) {


        ArrayList<ArrayList<Integer>> lists = new ArrayList<>();

        ArrayList<Integer> list1 = new ArrayList<>();
        list1.add(1);
        list1.add(2);
        list1.add(3);
        list1.add(4);
        list1.add(5);
        ArrayList<Integer> list2 = new ArrayList<>();
        list2.add(6);
        list2.add(7);
        list2.add(8);
        ArrayList<Integer> list3 = new ArrayList<>();
        list3.add(9);
        list3.add(10);
        list3.add(11);
        list3.add(12);

        lists.add(list1);
        lists.add(list2);
        lists.add(list3);
        printListVertically(lists.iterator());

    }

    public static void printListVertically(Iterator<ArrayList<Integer>> it){
        do{
            ArrayList<ArrayList<Integer>> lists = new ArrayList<>();
            ArrayList<Iterator<Integer>> a = new ArrayList<>();
            int i = 0;
            while(it.hasNext()){
                Iterator<Integer> iter = it.next().listIterator();
                System.out.println(iter.next());
                iter.remove();
                if(iter.hasNext())
                    it.remove();
            }
        } while(it.hasNext());

    }

    public static boolean getSize(Iterator<ArrayList<Integer>> it){

        return it.hasNext();
    }

}
