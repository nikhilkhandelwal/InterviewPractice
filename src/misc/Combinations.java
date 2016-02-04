package misc;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by nikhandelwal on 2/3/2016.
 */
public class Combinations {

    public static List<List<Integer>> combination(int n , int k ){


        List<List<Integer>> results = new ArrayList<>() ;

        combinationUtil(n, k, 1, new ArrayList<>(), results);

        return results;

    }

    public static void combinationUtil(int n , int k, int start, List<Integer> set, List<List<Integer>> results){

        if(k ==0 ){
            results.add(new LinkedList<>(set));
            return;
        }


        for(int i =start ; i <= n  ; i++){

            set.add(i);
            combinationUtil(n , k-1, i+1, set, results);
            set.remove(set.size()-1);
        }

    }

    public static void main(String [] args){

        for(List<Integer> set : combination(3,2)){
            System.out.println("Set: " );
            for(Integer i : set){
                System.out.print(i + ",");
            }

            System.out.println("");

        }
    }


}
