import java.util.concurrent.locks.ReentrantLock;

public class Sequence {
    private int counter;

    ReentrantLock lock = new ReentrantLock();

    public void getNext() {
      lock.lock();
      try {
          System.out.println(counter++ + " in " + Thread.currentThread().getName());
      }
      finally {
          lock.unlock();
      }
    }
}
