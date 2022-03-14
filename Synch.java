public class Synch {
    Magaz i;
    volatile int curent;

    public Synch(Magaz i){
        this.i = i;
    }

    public synchronized void write(){
        i.ItemsOnShelf[curent] = (int) (4 + Math.random() * (20));
        System.out.println("Write: " + i.ItemsOnShelf[curent]);
    }

    public synchronized int read(){
        System.out.println("Read: " + i.ItemsOnShelf[curent]);
        return i.ItemsOnShelf[curent++];
    }
}
