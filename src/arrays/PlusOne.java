package arrays;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by nikhandelwal on 12/29/2015.
 */
public class PlusOne{

        public static void plusOne(List<Integer> num){

            int n = num.size()-1;
            num.set(n, num.get(n)+1);
            for(int i = n; i>0& num.get(i)==10; i--){
                num.set(i,0);
                num.set(i-1,num.get(i-1)+1);
            }
            if(num.get(0)==10){
                num.set(0,0);
                num.add(0, 1);
            }

            System.out.println(num.toString());
        }

        public static void plusK(List<Integer> num, int k){
            int n = num.size()-1;
            num.set(n, num.get(n)+k);
            for(int i = n; i>0& num.get(i)>9; i--){
                num.set(i,num.get(i)%10);
                num.set(i-1,num.get(i-1)+1);
            }
            if(num.get(0)>9 ){
                num.set(0,num.get(0)%10);
                num.add(0, 1);
            }
            System.out.println(num.toString());
        }

        public static void addTwoLists(List<Integer> num1, List<Integer> num2){

            int n = num1.size()-1;

            List<Integer> result = new ArrayList<>();
            int carry = 0;
            for(int i = n; i>=0; i--){
                int sum = num1.get(i) + num2.get(i) +carry;
                 result.add(0, sum % 10);
                 carry = sum/10;
            }
            if(carry != 0){
                result.add(0, carry);
            }
            System.out.println(result.toString());

        }


        public static void main(String args[]) {

            List<Integer> num1 = new ArrayList<Integer>() ;
            num1.add(1);
            num1.add(9);
            num1.add(9);
            List<Integer> num2 = new ArrayList<Integer>() ;
            num2.add(9);
            num2.add(9);
            num2.add(9);
            //plusOne(num);
            //plusK(num,2);
            addTwoLists(num1,num2);


        }
}
