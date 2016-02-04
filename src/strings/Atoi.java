package strings;

/**
 * Created by nikhandelwal on 1/27/2016.
 */
public class Atoi {

    public static int atoi(String number){

        int num= 0;
        for(int i = 0; i< number.length() ; i++){

            num = num*10 + (number.charAt(i) -'0');

        }


        return num;
    }

    public static String itoa(int number){

        StringBuilder num = new StringBuilder();

        while(number > 0){

            num.append((char)(number %10 + '0'));
            number = number/10;
        }

        return num.reverse().toString();
    }

    public static void main(String [] args){

        System.out.println("number: " + atoi("1234"));
        System.out.println("number: " + itoa(1234));


    }


}
