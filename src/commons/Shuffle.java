package commons;

import java.security.SecureRandom;

/**
 * Created by nikhandelwal on 12/24/2015.
 */
public class Shuffle {


    public static void shuffleArray(Integer[] array) {

        SecureRandom generator = new SecureRandom();

        try {

            Thread.sleep(generator.nextInt(1000));
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        for (int i = 0; i < array.length; i++) {

            int x = generator.nextInt(array.length - 1);

            swap(array, i, x);
        }
    }


    public static void swap(Integer[] array, int i, int j) {

        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

}