package dailyex;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author Major Tom
 * @date 2020/11/24 15:12
 * @description 线程池练习
 */
public class ThreadPoolDemo {
    public static void main(String[] args) {
        ExecutorService executor= Executors.newFixedThreadPool(5);
        CountDownLatch end=new CountDownLatch(5);
        for (int i = 1; i < 6; i++) {
            ThreadDemo thread=new ThreadDemo(i,10*i,end);
            executor.execute(thread);
        }
        end.countDown();
        end.countDown();
        executor.shutdown();
    }
}

/**
 * 自定义线程类
 */
class ThreadDemo implements Runnable{
    private final int start;
    private final int end;
    private final CountDownLatch shutdown;

    public ThreadDemo(int start, int end, CountDownLatch shutdown) {
        this.start = start;
        this.end = end;
        this.shutdown = shutdown;
    }

    @Override
    public void run() {
        for (int i = start; i < end; i++) {
                System.out.println("子线程"+Thread.currentThread().getName()+"输出了......"+i);
        }
        shutdown.countDown();
    }
}