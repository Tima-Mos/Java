public class RunnableWrite implements Runnable{
    Synch bruh;

    public RunnableWrite(Synch bruh){
        this.bruh = bruh;
    }

    @Override
    public void run(){
          bruh.write();
    }
}
