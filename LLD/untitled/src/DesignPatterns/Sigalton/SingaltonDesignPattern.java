package DesignPatterns.Sigalton;

public class SingaltonDesignPattern {

    public static void main(String[] args) {

        SingalTonClass obj1 = SingalTonClass.getSingaltonClassInstance();
        SingalTonClass obj2 = SingalTonClass.getSingaltonClassInstance();

        System.out.println(obj1==obj2);

    }

}
