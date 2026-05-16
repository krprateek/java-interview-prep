package DesignPatterns.Sigalton;

public class SingalTonClass {

    private static SingalTonClass singalTonClassObj = null;

    private SingalTonClass()
    {
        System.out.println("instance created by :" + Thread.currentThread().getName());
    }

    public static  SingalTonClass getSingaltonClassInstance()
    {

            if(null == singalTonClassObj ) {
                synchronized (SingalTonClass.class) {
                    if(null== singalTonClassObj) {
                        singalTonClassObj = new SingalTonClass();
                    }
                }
            }

        return  singalTonClassObj;
    }
}
