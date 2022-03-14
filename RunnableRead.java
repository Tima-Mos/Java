public class RunnableRead implements Runnable{
    Synch bruh;

    public RunnableRead(Synch bruh){
        this.bruh = bruh;
    }

    @Override
    public void run(){
            bruh.read();
    }
}
