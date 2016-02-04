package misc;

/**
 * Created by nikhandelwal on 1/24/2016.
 */
public class TotalWaysToMakeChange {

    public static int totalChange(int [] coins, int m, int V){

        if(V==0 ) return 1;

        if( V < 0) return 0;

        int ways =0;
        for(int i = 0; i <m ; i++){

             ways = totalChange(coins, m, V - coins[i]) + totalChange(coins, m-1 , V);

        }

        return ways;
    }

    public static int totalChangeDP(int [] coins, int m, int V){


        int table[][] =  new int[V+1][coins.length];

        for (int i=0; i<m; i++)
            table[0][i] = 1;
        for(int i = 0; i <m ; i++){
            for(int j=1; j <= V ; j++) {
                int x = ( j >= coins[i]) ? table[j - coins[i]][i] :0;
                int y =  (i >= 1)? table[j][i-1] : 0;
                table[j][i] =  x + y;
            }
        }

        return table[V][coins.length-1];
    }

    public static void main(String [] args){

        int arr[] = {1, 2, 3};
        System.out.println(totalChangeDP(arr, 3, 4));
    }
}
