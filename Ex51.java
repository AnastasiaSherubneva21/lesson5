package lesson5;

import java.util.Set;

public class Ex51 {

    public static void main(String[] args) throws InterruptedException {

        CommonResource commonResource = new CommonResource();

        CommonResource1 commonResource1 = new CommonResource1();

        Thread t1 = new Thread(new CountThread1(commonResource1));
        Thread t2 = new Thread(new CountThread1(commonResource1));

        for (int i = 1; i < 4; i++){

            Thread t = new Thread(new CountThread(commonResource));
            t.setName("Thread " + i);
            if (t.getName().equals("Thread 1")) {
                System.out.println(t.getState());
            }
            t.start();
            if (t.getName().equals("Thread 1")) {
                System.out.println(t.getState());
            }

            t.join();
            if (t.getName().equals("Thread 1")) {
                System.out.println(t.getState());
            }
        }

        t1.start();
        t2.start();

        Thread.sleep(1000);

        System.out.println(t2.getState());
        System.exit(0);
    }
}

class CommonResource{

    int x;
    synchronized void increment(){
        x = 1;
        for (int i = 1; i < 4; i++){
            x += 1;
            try{
                Thread.sleep(1000);
                Set<Thread> threadSet = Thread.getAllStackTraces().keySet();
                for (Thread t : threadSet) {
                        //System.out.println(t.getName());
                        System.out.println(t.getState());
                }
            }
            catch(InterruptedException e){}
        }
    }
}

class CountThread implements Runnable{

    CommonResource res;
    CountThread(CommonResource res){
        this.res=res;
    }

    public void run(){
        res.increment();
    }
}

class CommonResource1 {
    synchronized void increment(){
        while (true) {}
    }
}

class CountThread1 implements Runnable {

    CommonResource1 res;

    CountThread1(CommonResource1 res) {
        this.res = res;
    }

    public void run() {
        res.increment();
    }
}
