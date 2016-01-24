package strings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

/**
 * Created by nikhandelwal on 10/27/2015.
 */
public class StringsTest {

    public static void main(String args[]) {

        System.out.println(getNonRepeatingChars("abbcde"));
    }
    public static Set<Character> getNonRepeatingChars(String str){

        char [] chars  = str.toCharArray();
        HashMap<Character , String> map = new HashMap<>();
        ArrayList<Character> uniqueList = new ArrayList<>();

        for( char c : chars){
            if(!map.containsKey(c)){
                map.put(c,null);
            }
        }

        return map.keySet();
    }
}
