package misc;

import java.util.ArrayList;

/**
 * Created by nikhandelwal on 1/28/2016.
 */
public class EightQueensProblem {

    public static final int GRID_SIZE = 8;

    public static ArrayList<Integer []> solve8Queens(){

        Integer board[] = new Integer [ 8];
        ArrayList<Integer []> results = new ArrayList<>();
        solve8QueensUtil(board, 7 , results);

        return results;

    }
    public static void solve8QueensUtil(Integer [] board, int row, ArrayList<Integer []> results){

        if(row == GRID_SIZE)
            results.add(board);

        for(int i=0; i < 8 ; i++){
            if(isValid(board, row, i)){
                board[row] = i;
                solve8QueensUtil(board, row + 1, results);
            }
        }

    }

    private static boolean isValid(Integer[] board, int row1, int column1) {

        for(int row2 = 0 ; row2<row1; row2++) {

            int column2 = board[row2];
            if (board[row2] == column1)
                return false;


            if (row2 - row1 == column2- column1)
                return false;

        }

        return true;

    }
}
