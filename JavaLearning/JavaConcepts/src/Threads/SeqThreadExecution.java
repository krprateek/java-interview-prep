package Threads;



public class SeqThreadExecution {

    public static void main(String[] args) throws InterruptedException {

        Thread t1 = new Thread(() ->
        {
            for(int i=0; i<100 ; i++){
                System.out.println( Thread.currentThread().getName() + " is executing");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        },"Thread1");

        Thread t2= new Thread(()->{
            for(int i=0;i<100;i++)
            {
                System.out.println(Thread.currentThread().getName() + " is executing");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        } , "Thread2");


            t1.start();
            t1.join();
            t2.start();



    }
}
