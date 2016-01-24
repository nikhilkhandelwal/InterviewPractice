package misc;

import java.util.ArrayList;
import java.util.HashSet;

/**
 * Created by nikhandelwal on 1/10/2016.
 */
public class GenerateAllBrackets {

    public static void main(String [] args){

        generateAllBrackets(3);
    }

    public static HashSet<String> generateAllBrackets(int n){


        HashSet<String> result = new HashSet<String>();
        generateAllBrackets("", n, result);
        for (String str : result)
            System.out.println(str);

        return result;
    }

    public static void generateAllBrackets(String current, int remaining, HashSet<String> total){

        if(remaining==0){
            total.add(current);
            return;
        }
        if (current == ""){
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                       generateAllBrackets("()", remaining - 1, total);
        }
        for(int i =0; i< current.length(); i++){

            String newString = current.substring(0,i)+"()"+current.substring(i,current.length());
           // System.out.println("new string: "+newString);
            generateAllBrackets(newString, remaining-1, total);

        }

    }
}
