package misc;

import org.omg.PortableInterceptor.INACTIVE;

/**
 * Created by nikhandelwal on 1/24/2016.
 */
public class MinimumCoinChangeProblem {


    public static int minimumCoinChangeDP(int [] coins, int m, int V){

        int [] table = new int[V+1];

        for(int i=1 ;i<= V; i++){

            table[i] = Integer.MAX_VALUE;
        }

        for(int j =1 ; j<=V; j++) {
            for (int i = 0; i < m; i++) {
                if (coins[i] <= j) {
                    int min = table[j - coins[i]];
                    if( min +1 < table[j] && min != Integer.MAX_VALUE   )
                        table[j] = table[j - coins[i]]+1;
                }
            }
        }
        return table[V];
    }
    public static int minimumCoinChange(int [] coins, int m, int V){

        if(V ==0 ) return 0;

        int minimum = Integer.MAX_VALUE;
        for(int i = 0 ; i< m; i++){
                if(coins[i] <= V){
                    int min = minimumCoinChange(coins, m, V - coins[i]);
                    if( min != Integer.MAX_VALUE && min +1 < minimum)
                        minimum = min+1;
                }
        }

        return minimum;
    }

    public static  void main(String [] args){

        int coins[] =  {1, 9, 5, 6};
        int m = coins.length;
        int V = 11;
        System.out.println("Minimum coins required " + minimumCoinChangeDP(coins, m, V));
    }
}
