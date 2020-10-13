package lesson5;

import java.util.Vector;

public class Ex52 {

    public static void main(String[] args) {

        Bufer bufer = new Bufer();
        Producer producer = new Producer(bufer);
        Consumer consumer = new Consumer(bufer);
        new Thread(producer).start();
        new Thread(consumer).start();
    }
}
