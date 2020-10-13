package lesson5;

class Consumer implements Runnable{

    Bufer bufer;
    Consumer(Bufer bufer){
        this.bufer=bufer;
    }
    public void run(){
        for (int i = 1; i < 6; i++) {
            try {
                bufer.get();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
