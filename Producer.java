package lesson5;

class Producer implements Runnable{

    Bufer bufer;

    Producer(Bufer bufer){
        this.bufer = bufer;
    }
    public void run(){
        for (int i = 1; i < 6; i++) {
            try {
                bufer.put();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
