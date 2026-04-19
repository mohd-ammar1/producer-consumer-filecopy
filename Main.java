package ThreadingPractice;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class Main {
    public static  volatile boolean reading = true;
    public static BlockingQueue<String> queue;
    public static void main(String[] args) throws InterruptedException {
         queue = new LinkedBlockingQueue(100);
         ReadThread readThread = new ReadThread();
         WriteThread writeThread = new WriteThread();
        readThread.start();
        writeThread.start();
        readThread.join();
        reading = false;
        writeThread.join();
    }
}
