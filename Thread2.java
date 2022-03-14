public class Thread2 extends Thread{
    Magaz obj;


    public Thread2(Magaz obj){
        this.obj = obj;
    }
    @Override
    public void run(){
        for (int i = 0; i < obj.ItemsOnShelf.length; i++) {
            System.out.println("Read: " + obj.ItemsOnShelf[i] + " from position " + i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e){

            }
        }

    }
}
