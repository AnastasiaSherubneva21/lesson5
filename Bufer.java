package lesson5;

import java.util.Vector;

class Bufer {

    private Vector<Cupboard> vector = new Vector(5);



    public void printVector() {
        System.out.println("Список товаров в буфере:");
        for (Cupboard x : vector) {
            x.printInfo();
        }
    }

    public synchronized void get() throws InterruptedException {
        while (vector.isEmpty()) {
            try {
                wait();
            }
            catch (InterruptedException e) {
            }
        }

        double t = 0;
        while (t < 0.1) {
            t = Math.random();
        }
        t = t*1000;
        Thread.sleep((long) t);

        vector.remove(0);
        System.out.println("Потребитель забрал 1 товар");
        System.out.println("Товаров в буфере: " + vector.size());
        printVector();
        notify();
    }
    public synchronized void put() throws InterruptedException {
        while (vector.size() >= 5) {
            try {
                wait();
            }
            catch (InterruptedException e) {
            }
        }
        Thread.sleep(500);
        CupboardBuilder builder = new CupboardBuilderImpl();
        Cupboard newcpb = builder
                .name()
                .color()
                .height()
                .build();
        vector.add(vector.size(), newcpb);
        System.out.println("Производитель добавил 1 товар");
        System.out.println("Товаров в буфере: " + vector.size());
        printVector();
        notify();
    }
}
