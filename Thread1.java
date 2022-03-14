public class Thread1 extends Thread{
    Magaz obj;


    public Thread1(Magaz obj){
        this.obj = obj;
    }
    @Override
    public void run(){
        for (int i = 0; i < obj.ItemsOnShelf.length; i++) {
            int a = (int) (4 + Math.random() * (20));
            obj.ItemsOnShelf[i] = a;
            obj.AllItems += a;
            System.out.println("Write: " + obj.ItemsOnShelf[i] + " to position " + i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e){

            }
        }
    }
}
