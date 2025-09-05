import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MultiThreadedCounter {
    private int counter = 0;
    private final Lock lock = new ReentrantLock();

    public void increment() {
        lock.lock(); // Acquire the lock
        try {
            counter++;
            System.out.println(Thread.currentThread().getName() + " incremented counter to: " + counter);
        } finally {
            lock.unlock(); // Release the lock
        }
    }

    public static void main(String[] args) {
        MultiThreadedCounter counter = new MultiThreadedCounter();
        Thread t1 = new Thread(new CounterTask(counter), "Thread 1");
        Thread t2 = new Thread(new CounterTask(counter), "Thread 2");
        Thread t3 = new Thread(new CounterTask(counter), "Thread 3");

        t1.start();
        t2.start();
        t3.start();
    }
}

class CounterTask implements Runnable {
    private final MultiThreadedCounter counter;

    public CounterTask(MultiThreadedCounter counter) {
        this.counter = counter;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            counter.increment();
            try {
                Thread.sleep(100); // Sleep to simulate some work and allow context switching
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}
