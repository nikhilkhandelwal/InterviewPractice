package concurency;

/**
 * Created by nikhandelwal on 12/24/2015.
 */
class Runner extends Thread {

    @Override
    public void run() {


        for (int i = 0; i < 10; i++) {

            try {
                Thread.sleep(100);
                System.out.println(i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}

class Runner1 implements Runnable {

    @Override
    public void run() {


        for (int i = 0; i < 10; i++) {

            try {
                Thread.sleep(100);
                System.out.println(i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}

public class App {


    public static void main(String[] args) {

//        Runner r1 = new Runner();
//        Runner r2 = new Runner();
//        r1.start();
//        r2.start();

        Thread t1 =  new Thread(new Runner1());
        Thread t2 = new Thread(new Runner1());

        t1.start();
        t2.start();
    }
}
