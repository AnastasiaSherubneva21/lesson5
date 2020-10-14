package lesson5;

import java.util.Set;

public class Ex51 {

    public static void main(String[] args) throws InterruptedException {

        CommonResource commonResource = new CommonResource();

        CommonResource1 commonResource1 = new CommonResource1();

        Thread t = new Thread(new CountThread(commonResource));

        t.setName("Thread 1");
        System.out.println(t.getState());

        t.start();
        System.out.println(t.getState());

        t.join();
        System.out.println(t.getState());

        Thread t1 = new Thread(new CountThread1(commonResource1));
        Thread t2 = new Thread(new CountThread1(commonResource1));

        t1.start();
        t2.start();

        Thread.sleep(1000);

        System.out.println(t2.getState());
        System.exit(0);
    }
}

class CommonResource{

    synchronized void synchr(){

        for (int i = 1; i < 3; i++){
            try{
                Thread.sleep(1000);
                Set<Thread> threadSet = Thread.getAllStackTraces().keySet();
                for (Thread t : threadSet) {
                    if (t.getName().equals("Thread 1")) {
                        System.out.println(t.getState());
                    }
                    if (t.getName().equals("main")) {
                        System.out.println(t.getState());
                    }
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
        res.synchr();
    }
}

class CommonResource1 {
    synchronized void synchr(){
        while (true) {}
    }
}

class CountThread1 implements Runnable {

    CommonResource1 res;

    CountThread1(CommonResource1 res) {
        this.res = res;
    }

    public void run() {
        res.synchr();
    }
}
