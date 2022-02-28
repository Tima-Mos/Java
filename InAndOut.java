import java.io.IOException;
import java.io.OutputStream;
import java.io.Writer;
import java.nio.charset.StandardCharsets;

public class InAndOut {
    public static void output(IDK o, OutputStream out) throws IOException {
        var data = o.toString().getBytes();
        out.write(data);
        out.flush();
        out.close();
    }
    public static void write(IDK o, Writer out)throws IOException{
        out.write(o.toString());
        out.flush();
        out.close();
    }
}
