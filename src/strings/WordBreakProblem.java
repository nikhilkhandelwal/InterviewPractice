package strings;

import java.util.HashSet;

/**
 * Created by nikhandelwal on 1/28/2016.
 */
public class WordBreakProblem {

    public static boolean isWordInDictonary(String word){

        int size  = word.length();
        if(size == 0)
            return true;

        for(int i= 1 ; i<= size ; i++){

            String temp = word.substring(i, size);
            if(dictionaryContains(word.substring(0,i))  && isWordInDictonary(temp))
                return true;
        }

        return false;

    }


    public static boolean isWordInDictonaryDP(String word){

        int size  = word.length();
        if(size == 0)
            return true;

        for(int i= 1 ; i<= size ; i++){

            String temp = word.substring(i, size);
            if(dictionaryContains(word.substring(0,i))  && isWordInDictonary(temp))
                return true;
        }

        return false;

    }


    public static boolean dictionaryContains(String word)
    {
            String dictionary[] = {"mobile","samsung","sam","sung","man","mango",
                "icecream","and","go","i","like","ice","cream"};
        int size = dictionary.length;
        for (int i = 0; i < size; i++) {
            if (dictionary[i].equals(word)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String [] args){

        System.out.println(isWordInDictonary("samsungandmango"));
    }
}
