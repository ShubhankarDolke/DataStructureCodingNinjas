package DistributedComputingPrac;
import java.util.concurrent.locks.ReentrantLock;

public class LockExample {
    // Shared resource
    private static int counter = 0;
    // Create a ReentrantLock object
    private static ReentrantLock lock = new ReentrantLock();

    public static void main(String[] args) {
        // Create an array of threads
        Thread[] threads = new Thread[10];

        // Initialize and start the threads
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(new CounterIncrementer());
            threads[i].start();
        }

        // Wait for all threads to complete
        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        // Print the final value of the counter
        System.out.println("Final counter value: " + counter);
    }

    static class CounterIncrementer implements Runnable {
        @Override
        public void run() {
            for (int i = 0; i < 100000; i++) {
                // Acquire the lock before accessing the shared resource
                lock.lock();
                try {
                    counter++;
                } finally {
                    // Release the lock after accessing the shared resource
                    lock.unlock();
                }
            }
        }
    }
}
