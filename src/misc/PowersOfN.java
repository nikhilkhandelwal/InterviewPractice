package misc;

/**
 * Created by nikhandelwal on 1/21/2016.
 */
public class PowersOfN {


    public static float power(int num, int n){

        if(n==0) return 1;
        float y = power(num, n/2);

        if( n%2 ==0)
            return y*y;
        else
            return num*y*y;

    }

    public static void main(String [] args){

        System.out.println(power(4,3));
    }
}
