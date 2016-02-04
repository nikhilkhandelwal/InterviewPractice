package misc;

import java.util.ArrayList;
import java.util.HashSet;

/**
 * Created by nikhandelwal on 1/27/2016.
 */
public class PowerSet {

    public static void generatePowerSet(int [] remaining, int n, HashSet<Integer> set, ArrayList<HashSet<Integer>> results){

        if(n == 0) {
            results.add(set);
            return ;
        }
        HashSet<Integer> withElement = new HashSet<>();
        int element = remaining[n-1];
        withElement.addAll(set);
        withElement.add(element);
        generatePowerSet(remaining, n - 1, withElement, results);
        generatePowerSet(remaining, n-1, set, results);

    }

    public static void main(String [] args){

        int [] nums = {1,2,3};
        HashSet<Integer> result = new HashSet<>();
        ArrayList<HashSet<Integer>> results = new ArrayList<>();

        generatePowerSet(nums, 3, result, results);

        int count = 0;
        for(HashSet<Integer> set : results){
            System.out.println("Set :");
            for(Integer i : set){

                System.out.print(i + " , ");
            }
            count ++;
            System.out.println("");
        }

        System.out.println(count);
    }
}
