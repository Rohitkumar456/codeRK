

import java.util.*;
public class MultiThreadingBasics {
    public static void main(String[] args) {

        // long startTime = System.currentTimeMillis();
        // for(int i=0;i<10000;i++){
        //     System.out.println(i);
        // }
        // long endTime = System.currentTimeMillis();
        // System.out.println("total exec time = "+(endTime-startTime));

        long startTime = System.currentTimeMillis();
        Another an = new Another();
        an.execute();
        long endTime = System.currentTimeMillis();
        System.out.println("total exec time = "+(endTime-startTime));
    }
}

class Another{
    public void execute(){
        Task1 thread1 = new Task1(0);
        Task1 thread2 = new Task1(25);
        Task1 thread3 = new Task1(50);
        Task1 thread4 = new Task1(75);
        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        try {
        } catch (Exception e) {
            //TODO: handle exception
        }
    }
}


class Task1 extends Thread{

    int var;
    Task1(int x){
        this.var = x;
    }

    public void run(){
        try {
            for(int i=0;i<25;i++){
                System.out.println(var+i);
                if((var+i)==76){
                    System.out.println("Thread interrupted");
                    Thread.currentThread().interrupt();
                }
            }
        } catch (Exception e) {
            //TODO: handle exception
        }finally{
            System.out.println("thread finished processing");
        }
    }
    public int getVar(){
        return this.var;
    }
}
