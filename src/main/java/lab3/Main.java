package lab3;

public class Main {
    public static ThreadLocal<Double> threadLocalValue = new ThreadLocal<>();

    private static class MyThread1 extends Thread{
        public void run(){
            threadLocalValue.set(Math.random());
            System.out.println(threadLocalValue.get() + " in " + Thread.currentThread().getName());
        }
    }
    private static class MyThread2 extends Thread{
        public void run(){
            threadLocalValue.set(Math.random());
            System.out.println(threadLocalValue.get() + " in " + Thread.currentThread().getName());
        }
    }
    public static /*volatile*/ Boolean stop = false;

    public static class MyThread extends Thread {

        public void run() {
            int i = 1;
            while (!stop) {
                i++;
            }
            System.out.println("Thread stop i = " + i);
        }
    }

    public static void main(String[] args) {
        MyThread test = new MyThread();
        test.start();
        try {
            Thread.sleep(1000);
        }
        catch (InterruptedException ex){
            ex.printStackTrace();
        }
        stop = true;
        System.out.println("Now, in main thread stop is: " + stop);
//        for(int i = 0; i < 2; i++) {
//            new MyThread1().start();
//            new MyThread2().start();
//        }
    }
}
