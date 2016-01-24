package misc;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by nikhandelwal on 1/5/2016.
 */
public class RestoreIPAddress {

    public static List<String> result;
    public static void main(String[] args) {

        restoreIpAddresses("25525511135");

    }
    public static List<String> restoreIpAddresses(String s) {



        result = new ArrayList<>();
       helper("",s, 4, result );

        for(String ch: result)
            System.out.println(ch);

        return result;
    }

    public static void helper (String used, String remaining, int numOfPoints, List<String> validAddress){

        if(numOfPoints ==0 && remaining.length()>0){
            return;
        }
        if (numOfPoints ==0 && remaining.length()==0){
            validAddress.add(used);
            return ;
        }

        if(remaining.length() > numOfPoints*3){
            return;
        }

        for(int i =1; i<=3 && i <= remaining.length() ;i++){

           // System.out.println(remaining);
            String newString  = remaining.substring(0,i);
            if(Integer.parseInt(newString) >255)
                break;
            if((Integer.parseInt(newString)+"").length() < newString.length())
                break;
            String newUsed = used == "" ? Integer.parseInt(newString)+"": used+"."+Integer.parseInt(newString);
            String newRemaining = remaining.substring(i,remaining.length());
            if(newRemaining.length() > (numOfPoints-1)*3){
                continue;
            }
            if(numOfPoints-1 ==0 && newRemaining.length()>0){
                continue;
            }
            helper(newUsed, newRemaining, numOfPoints-1, validAddress);

        }

    }
}
