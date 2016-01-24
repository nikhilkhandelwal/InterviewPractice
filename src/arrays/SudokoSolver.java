package arrays;

import java.util.HashSet;
import java.util.LinkedList;

/**
 * Created by nikhandelwal on 12/30/2015.
 */
public class SudokoSolver {

    public boolean solveSudoku(char[][] board) {

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    HashSet<Character> possible = getPossibleNumbers(board, i,j);
                    for (Character c: possible) {
                       // if (isValid(board, i, j, c)) {
                            board[i][j] = c;
                            if (solveSudoku(board)) {
                                return true;
                            } else {
                                board[i][j] = '.';
                            }
                     //   }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    public static HashSet<Character> getPossibleNumbers(char[][] board, int i, int j){

        HashSet<Character> possible = new HashSet<>();
        for (char c = '1'; c <= '9'; c++){
            possible.add(c);
        }

        for(int row = 0; row < 9; row++)
            possible.remove(board[row][j]);

        //Check row
        for(int col = 0; col < 9; col++)
            possible.add(board[i][col]);

        //Check 3 x 3 block
        for(int row = (i / 3) * 3; row < (i / 3) * 3 + 3; row++)
            for(int col = (j / 3) * 3; col < (j / 3) * 3 + 3; col++)
                possible.add(board[row][col]);

        return  possible;

    }

    public boolean isValid(char[][] board, int i, int j, char c){
        //Check colum
        for(int row = 0; row < 9; row++)
            if(board[row][j] == c)
                return false;

        //Check row
        for(int col = 0; col < 9; col++)
            if(board[i][col] == c)
                return false;

        //Check 3 x 3 block
        for(int row = (i / 3) * 3; row < (i / 3) * 3 + 3; row++)
            for(int col = (j / 3) * 3; col < (j / 3) * 3 + 3; col++)
                if(board[row][col] == c)
                    return false;
        return true;
    }
}
