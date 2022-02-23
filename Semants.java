import java.util.Arrays;
import java.util.Objects;

public class Semants implements IDK {
    int[] ItemsOnShelf;
    String theme;
    int Reserved;
    int AllItems;
    String Type = "Semants";
    public Semants(int count, String theme, int res){
        this.ItemsOnShelf = new int[count];
        this.theme = theme;
        this.Reserved = res;
        for (int i = 0; i<count; i++) {
            int a = (int) (4 + Math.random() * (20));
            this.ItemsOnShelf[i] = a;
            this.AllItems += a;
        }
    }
    public Semants(){
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
    public void SeeItem(int pos){
        try {
            System.out.println(this.ItemsOnShelf[pos - 1]);
        }
        catch (IndexOutOfBoundsException e){
            System.out.println("Out of range, dummy ;)");
            System.out.println("┬┴┬┴┤( ͡° ͜ʖ├┬┴┬┴");
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
        return "Semants{" +
                "ItemsOnShelf=" + Arrays.toString(ItemsOnShelf) +
                ", theme='" + theme + '\'' +
                ", Reserved=" + Reserved +
                ", AllItems=" + AllItems +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Semants)) return false;
        Semants semants = (Semants) o;
        return Objects.equals(Type, semants.Type);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(theme, Reserved, AllItems, Type);
        result = 31 * result + Arrays.hashCode(ItemsOnShelf);
        return result;
    }
}
