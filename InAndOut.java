import java.io.*;
import java.nio.charset.StandardCharsets;


public class InAndOut {
    public static void output(IDK o, OutputStream out) throws IOException {
        var data = o.toString().getBytes();
        out.write(data);
        out.flush();
    }
    public static void write(IDK o, Writer out)throws IOException{
        out.write(o.toString());
        out.flush();
    }
    public static String input(InputStream in) throws IOException{
        byte bytes[] = new byte[in.available()];
        in.read(bytes);
        String str = new String(bytes);
        return str;
    }
    public static String readIDK(BufferedReader in) throws IOException{
        String str = in.readLine();
        return str;
    }
    public static void serializeIDK(IDK o, ObjectOutputStream out) {
        try {
            out.writeObject(o);
            out.close();
        } catch (IOException i){
            i.printStackTrace();
        }
    }
    public static IDK deserializeIDK(ObjectInputStream in) {
        try {
            IDK o = null;
            o = (IDK) in.readObject();
            in.close();
            return o;
        } catch (IOException i) {
            i.printStackTrace();
            return null;
        } catch (ClassNotFoundException c) {
            System.out.println("интерфейс IDK не найден");
            c.printStackTrace();
            return null;
        }
    }
    public static IDK Syncronized (IDK i){
        return (IDK) new SynchronizedIDKClass();
    }
}
