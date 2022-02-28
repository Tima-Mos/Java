import java.io.IOException;
import java.io.OutputStream;
import java.io.Writer;
import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;

public class Magaz implements IDK {
    int[] ItemsOnShelf;
    String theme;
    int Reserved;
    int AllItems;
    String Type = "Magaz";
    public Magaz(int count, String theme, int res){
        this.ItemsOnShelf = new int[count];
        this.theme = theme;
        this.Reserved = res;
        for (int i = 0; i<count; i++) {
            int a = (int) (4 + Math.random() * (20));
            this.ItemsOnShelf[i] = a;
            this.AllItems += a;
        }
    }
    public Magaz(){
        System.out.println("создан пустой склад");
        this.theme = "без темы";
    }
    public String type(){
        return Type;
    }
    public void Print(){
        String SVec = Arrays.toString(this.ItemsOnShelf);
        System.out.println(SVec);
    }
    public void output(OutputStream out) throws IOException {
        var data = this.theme;
        byte[] bytes = data.getBytes();
        out.write(bytes);
    }
    public void write(Writer out) throws IOException {
        out.write(this.theme);
        out.flush();
    }
    public void SeeItem(int pos){
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
    public void See(String which){
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
    public void Update(int pos, int n){
        this.ItemsOnShelf[pos] = n;
    }
    public int NotReserved(){
        int coc = 0;
        for (int i = 0; i<this.ItemsOnShelf.length; i++){
            coc += this.ItemsOnShelf[i] - this.Reserved;
        }
        return coc;
    }

    @Override
    public String toString() {
        return "Magaz{" +
                "ItemsOnShelf=" + Arrays.toString(ItemsOnShelf) +
                ", theme='" + theme + '\'' +
                ", Reserved=" + Reserved +
                ", AllItems=" + AllItems +
                '}';
    }

//    @Override
//    public String toString() {
//        String SVec = Arrays.toString(this.ItemsOnShelf);
//        return "mass: " + SVec + '\'' +
//                "theme: " + this.theme + '\'' +
//                "Usualy reserved: " + this.Reserved + '\'' + "Number of Items: " + this.AllItems;
//    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Magaz)) return false;
        Magaz magaz = (Magaz) o;
        return Type.equals(magaz.Type);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(theme, Reserved, AllItems);
        result = 31 * result + Arrays.hashCode(ItemsOnShelf);
        return result;
    }
}
