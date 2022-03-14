public class RunnableRead implements Runnable{
    Synch bruh;

    public RunnableRead(Synch bruh){
        this.bruh = bruh;
    }

    @Override
    public void run(){
        try {
            for (int i = 0; i < bruh.i.ItemsOnShelf.length; i++)
                bruh.read();
        } catch (InterruptedException exc) {
            System.out.println(exc.getMessage());
            exc.printStackTrace();
        }
    }
}
