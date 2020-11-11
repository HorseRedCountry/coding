package dailyex;

/**
 * @author Major Tom
 */
public class Test {

    public static void main(String[] args) {
        new MyThread().start();
        new MyThread(new MyRunnable()).start();

    }

    static class MyThread extends Thread{
        MyThread(){}

        MyThread(Runnable r){
            super(r);
        }

        @Override
        public void run(){
            System.out.println("inside thread");
        }
    }

    static class MyRunnable implements Runnable {

        @Override
        public void run() {
            System.out.println("inside runnable");
        }
    }
}
