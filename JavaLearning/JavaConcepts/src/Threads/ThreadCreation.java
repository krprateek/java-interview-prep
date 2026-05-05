package Threads;

public class ThreadCreation {

    public static void main(String[] args) {



        try {

            for (int i = 1; i < 100; i++) {
                threadA firstThread = new threadA();
                Thread secondThread = new Thread(() -> {
                    System.out.println("Created using Runnable");
                });
                firstThread.start();
                secondThread.start();



                
                //secondThread.join();
            }
        }
        catch( Exception e)
        {

            System.out.println("Thread intrupted");
        }




    }

    public static class threadA extends Thread{

        @Override
        public void run() {
            System.out.println("thread created using Thread class");
        }
    }


}

