

import java.util.*;

interface A{
    int x = 10;
    void m1();
} 

class B implements A{
    public int x=20;
    public void m1(){
        System.out.println("in B");
    }
    // public void m2(){
    //     System.out.println("in b");
    // }
}

class C extends B{
    public int x = 30;
    public void m1(){
        System.out.println("in c");
    }
    public void m2(){
        System.out.println("in c's m2");
    }
    public void m3(){
        System.out.println("in c's m3");
    }
}

class D extends C{
    
}

public class InterfacesTest {
    public static void main(String[] args) {
        A a = new B();
        B b = new B();
        b = new C();
        a = new C();
        // System.out.println(a.x);
        a.m1();

        b = new D();
        b.m1();
    }
}
