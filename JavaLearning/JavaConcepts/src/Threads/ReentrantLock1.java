package Threads;

import java.util.Currency;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLock1 {

    static  int totalValue = 100;
    private static final Lock lock = new ReentrantLock();
    public static void main(String[] args) throws InterruptedException {



        Thread t1 = new Thread(() -> {
            for(int i=0;i<5;i++) {
                withDraw(10);
            }},"Tread1");

        Thread t2 = new Thread(() -> {
            for(int i=0;i<10;i++) {

                withDraw(5);
            }},"Thread2");

        t1.start();
       // t1.join();
        t2.start();

    }

    public static void withDraw(int valueToWithdraw)
    {
        boolean lockAquired = false;

        try {
            lockAquired = lock.tryLock(10, TimeUnit.SECONDS);
            if(lockAquired) {
                if (totalValue > 0) {
                    totalValue -= valueToWithdraw;
                    System.out.println(valueToWithdraw + " is been withdrawn by thread :" + Thread.currentThread().getName()+ " current balance is : " + totalValue);
                } else {
                    System.out.println("Balance is less then 0");
                }
            }
            else {
                System.out.println(Thread.currentThread().getName() + " was not able to aquire lock");
            }
        }catch (InterruptedException ex)
        {
            Thread.currentThread().interrupt();
            System.out.println("Thread interrupted because : " + ex.getMessage());
        }finally {
            if (lockAquired)
            {
                lock.unlock();
            }
        }
    }
}
