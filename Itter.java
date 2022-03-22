import java.util.Iterator;

public class Itter implements Iterator<Integer> {
    private int start=0;
    private int stop;
    int[]arr=null;
    public Itter(int a[]){
        arr=a;
        stop=a.length;
    }
    private int current=0;
    @Override
    public boolean hasNext() {
        return current<stop;
    }

    @Override
    public Integer next() {
        return arr[current++];
    }
}
