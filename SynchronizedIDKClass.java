import java.io.IOException;
import java.io.OutputStream;
import java.io.Writer;
import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;

public class SynchronizedIDKClass implements IDK, java.io.Serializable{
    int[] ItemsOnShelf;
    String theme;
    int Reserved;
    int AllItems;
    IDK jop;
    String Type = "SynchronizedIDKClass";

    public SynchronizedIDKClass(IDK jop){
            this.jop = jop;
    }
    public SynchronizedIDKClass(){
        System.out.println("создан пустой склад");
        this.theme = "без темы";
    }
    public synchronized String type(){
        try {
            return Type;
        } catch (NullPointerException e){
            return null;
        }
    }
    public synchronized void Print(){
        String SVec = Arrays.toString(this.ItemsOnShelf);
        System.out.println(SVec);
    }
    public synchronized void output(OutputStream out) throws IOException {
        byte[] bytes = this.theme.getBytes();
        out.write(bytes);
        out.flush();
    }
    public synchronized void write(Writer out) throws IOException {
        out.write(this.theme);
        out.flush();
    }
    public synchronized void set(int place, int value){
        try{
            ItemsOnShelf[place] = value;
        } catch (Exception e){

        }
    }
    public synchronized void SeeItem(int pos){
        if (pos > this.ItemsOnShelf.length){
            System.out.println("Oh, thats too big for me sweety, try a lesser number");
            Scanner console = new Scanner(System.in);
            int n = console.nextInt();
            SeeItem(n);
        }
        else if (pos < 0){
            System.out.println("that's not what i wanted, i dont have such indexes (눈_눈)");
            Scanner console = new Scanner(System.in);
            int n = console.nextInt();
            SeeItem(n);
        } else {
            System.out.println("Here you go");
            System.out.println(this.ItemsOnShelf[pos - 1]);
        }
    }
    public synchronized void See(String which){
        if (which == "res"){
            System.out.println(this.Reserved);
        }
        else if (which == "all"){
            System.out.println(this.AllItems);
        }
        else {
            System.out.println(this.theme);
        }
    }
    public synchronized void Get(String which){
        if (which == "res"){
            System.out.println(this.Reserved);
        }
        else if (which == "all"){
            System.out.println(this.AllItems);
        }
        else {
            System.out.println(this.theme);
        }
    }
    public synchronized void Update(int pos, int n){
        this.ItemsOnShelf[pos] = n;
    }
    public synchronized int NotReserved(){
        int coc = 0;
        for (int i = 0; i<this.ItemsOnShelf.length; i++){
            coc += this.ItemsOnShelf[i] - this.Reserved;
        }
        return coc;
    }

    @Override
    public synchronized String toString() {
        return "SynchronizedIDKClass{" +
                "ItemsOnShelf=" + Arrays.toString(ItemsOnShelf) +
                ", theme='" + theme + '\'' +
                ", Reserved=" + Reserved +
                ", AllItems=" + AllItems +
                ", Type='" + Type + '\'' +
                '}';
    }


}
