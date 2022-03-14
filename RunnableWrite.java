public class RunnableWrite implements Runnable{
    Synch bruh;

    public RunnableWrite(Synch bruh){
        this.bruh = bruh;
    }

    @Override
    public void run(){
        try {
            for (int i = 0; i < bruh.i.ItemsOnShelf.length; i++)
            bruh.write();
        } catch (InterruptedException exc) {
            System.out.println(exc.getMessage());
            exc.printStackTrace();
        }
    }
}
