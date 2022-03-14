public class Synch {
    Magaz i;
    volatile int curent = 0;
    private volatile boolean isElSet = false;


    public Synch(Magaz i){
        this.i = i;
    }

    public void write() throws InterruptedException {
        synchronized (i) {
            while (isElSet) {
                i.wait();
            }
            i.ItemsOnShelf[curent] = (int) (4 + Math.random() * (20));
            isElSet = true;
            System.out.println("Write: " + i.ItemsOnShelf[curent]);
            i.notifyAll();
        }
    }

    public void read() throws InterruptedException{
        synchronized (i) {
            while (!isElSet) {
                i.wait();
            }
            isElSet = false;
            System.out.println("Read: " + i.ItemsOnShelf[curent++]);
            i.notifyAll();
        }
    }
}
