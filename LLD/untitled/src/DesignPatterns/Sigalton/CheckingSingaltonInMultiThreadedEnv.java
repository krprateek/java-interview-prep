package DesignPatterns.Sigalton;

public class CheckingSingaltonInMultiThreadedEnv {

    public static void main(String[] args) {

        SingalTonClass[] obj1 = new SingalTonClass[1];
        SingalTonClass[] obj2 = new SingalTonClass[1];
        Thread thread1 = new Thread(
                () ->
                        obj1[0] = SingalTonClass.getSingaltonClassInstance() ,"Thread1");
        Thread thread2 = new Thread(
                () ->
                        obj2[0] = SingalTonClass.getSingaltonClassInstance() ,"Thread2");

        thread1.start();
        thread2.start();


        System.out.println(obj1[0]==obj2[0]);


    }
}
