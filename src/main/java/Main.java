public class Main {


    public static class MyThread extends Thread {
        private Sequence s;

        MyThread(Sequence s) {
            this.s = s;
        }

        @Override
        public void run() {
//            Object object = ThreadSafeSingleton.getInstanceUsingDoubleLocking();
//               Object object = LazyInitializedSingleton.getInstance();
                s.getNext();
        }
    }


    public static void main(String[] args) {
        Sequence s = new Sequence();
        MyThread[] threads = new MyThread[10];
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new MyThread(s);
        }
        for(int i =0; i< threads.length; i++){
            threads[i].start();
        }
    }
}