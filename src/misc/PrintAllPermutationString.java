package misc;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by nikhandelwal on 1/7/2016.
 */
public class PrintAllPermutationString {

    public static void main(String [] args) {

        printAllPermutation("", "abcd");

    }

    public static void printAllPermutation (String used, String remaining){

        if (used.length()==4){
            System.out.println(used);
            return ;
        }

        for(int i =0; i< remaining.length() ;i++){


            String newUsed = used + remaining.charAt(i);
            String newRemaining = remaining.substring(0,i)+remaining.substring(i + 1, remaining.length());
            //System.out.println("used: "+newUsed);
            //System.out.println("remaining: "+newRemaining);
            printAllPermutation(newUsed, newRemaining);

        }

    }

    }
