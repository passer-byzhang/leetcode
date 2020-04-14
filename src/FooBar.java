import javax.jws.soap.SOAPMessageHandlers;
import java.util.concurrent.Semaphore;

public class FooBar {
    private int n;
    Semaphore j = new Semaphore(0);
    Semaphore k = new Semaphore(1);
    public FooBar(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            k.acquire();
            // printFoo.run() outputs "foo". Do not change or remove this line.
            printFoo.run();
            j.release();
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            j.acquire();
            // printBar.run() outputs "bar". Do not change or remove this line.
            printBar.run();
            k.release();
        }
    }
    public static class printBar implements Runnable {


        public void run() {
            System.out.print("Bar");
        }
    }
    public static class printFoo implements Runnable {


        public void run() {
            System.out.print("Foo");
        }
    }
    public static void  main(String arg[]){
        FooBar f = new FooBar(2);
        printFoo Foo = new printFoo();
        printBar Bar = new printBar();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    f.foo(Foo);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    f.bar(Bar);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

          t1.start();
          t2.start();


        }


}
