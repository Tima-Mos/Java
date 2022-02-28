import java.io.IOException;
import java.io.OutputStream;
import java.io.Writer;

public interface IDK {
    void SeeItem(int pos);
    void See(String which);
    void Update(int pos, int n);
    void Print();
    int NotReserved();
    String type();
    void output(OutputStream out) throws IOException;
    void write(Writer out)throws IOException;
}
