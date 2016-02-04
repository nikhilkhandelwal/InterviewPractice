package misc;

/**
 * Created by nikhandelwal on 1/30/2016.
 */
public class UniqueWaysInGrid {

    public static int uniquePaths(int m, int n) {

        return uniquePathsUtil(0, 0 ,m,n);
    }

    private static int uniquePathsUtil( int i, int j ,int m, int n) {

        if((i >=m ) || (j >=n )){

            return 0;
        }

        if((i == m-1 )&& (j ==  n-1)){

            return 1;
        }

        return  uniquePathsUtil(i + 1, j, m, n) + uniquePathsUtil(i, j + 1, m, n);

    }

    public static void main(String [] args){

        System.out.println(uniquePaths(2,2));
    }
}
