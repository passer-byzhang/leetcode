import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

import static java.util.concurrent.Executors.newFixedThreadPool;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class foo {
    public foo() {

    }
    Semaphore  i = new Semaphore(0) ;
    Semaphore  j = new Semaphore(0) ;
    public void first(Runnable printFirst) throws InterruptedException {

        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        i.release();
    }

    public void second(Runnable printSecond) throws InterruptedException {
        i.acquire();
        // printSecond.run() outputs "second". Do not change or remove this line.
        printSecond.run();
        j.release();
    }

    public void third(Runnable printThird) throws InterruptedException {
        j.acquire();
        // printThird.run() outputs "third". Do not change or remove this line.
        printThird.run();
    }

    public static void main(String arg[]) throws InterruptedException {
        foo f = new foo();
        printFirst One = new printFirst();
        printSecond Two = new printSecond();
        printThird Three = new printThird();
        ExecutorService pool=Executors.newFixedThreadPool(3);


        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    f.second(Two);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    f.first(One);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        Thread t3 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    f.third(Three);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

    t1.start();
    t2.start();
    t3.start();






    }



}
