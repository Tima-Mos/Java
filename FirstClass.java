import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.OutputStream;
import java.io.Writer;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.lang.Object;
import java.util.AbstractCollection;
import java.util.AbstractList;

public class FirstClass {
    public static void Exeptions(){
        Scanner console = new Scanner(System.in);
        System.out.println("for Magaz: ");
        int n = console.nextInt();
        Magaz mag = new Magaz(5, "колбаски", 3);
        mag.SeeItem(n);
        System.out.println("for Semants: ");
        n = console.nextInt();
        Semants ses = new Semants(5, "жужло", 3);
        ses.SeeItem(n);
    }
    public static void Lab2(){
        Scanner console = new Scanner(System.in);
        int n = console.nextInt();
        Vector vec = new Vector(n);
        vec.See(vec.Vec, 3);
        vec.Update(vec.Vec, 3, 15);
        vec.Print(vec.Vec);
        vec.Length(vec.Vec);
        vec.Min(vec.Vec);
        vec.Max(vec.Vec);
        vec.Sort(vec.Vec);
        vec.Print(vec.Vec);
        System.out.println(vec.euclidean_norm(vec.Vec));
        System.out.println(vec.UmnNum(vec.Vec, 3));
        Vector vec2 = new Vector(n);
        vec.Print(vec2.Vec);
        System.out.println(vec.Plus(vec.Vec, vec2.Vec));
        System.out.println(vec.Scolar(vec.Vec, vec2.Vec));
        vec.Print(vec.Vec);
    }

    public static void printkk(IDK[] kk){
        for (int i = 0; i<kk.length; i++){
            System.out.println(kk[i]);
        }
    }

    public static void Lab3(){
        Scanner console = new Scanner(System.in);
        int n = console.nextInt();
        Magaz se = new Magaz(n, "шишки", 4);
        Semants sis = new Semants();
        Vector.Print(se.ItemsOnShelf);
        System.out.println(se);
        IDK[] kk = new IDK[]{
                new Semants(5, "жужло", 3),
                new Magaz(8, "колбаски", 2),
                new Semants(5, "жужло", 3),
                new Magaz(6, "булочки", 4)
        };
        printkk(kk);
        List<IDK> where = new ArrayList<IDK>();
        for (int i = 0; i< kk.length; i++){
            for (int j = 0; j<kk.length; j++){
                if (i == j){
                    continue;
                } else {
                    if (kk[i].NotReserved() == kk[j].NotReserved()) {
                        where.add(kk[i]);
                        where.add(kk[j]);
                    }
                }
            }
        }
        IDK[] wherere = new IDK[where.size()];
        where.toArray(wherere);
        printkk(wherere);
        List<IDK> FirstMas = new ArrayList<IDK>();
        List<IDK> SecMas = new ArrayList<IDK>();
        FirstMas.add(kk[0]);
        for (int i = 1; i< kk.length; i++){
            if (kk[0].type() == kk[i].type()){
                FirstMas.add(kk[i]);
            }
            else {
                SecMas.add(kk[i]);
            }
        }
        IDK[] Fi = new IDK[FirstMas.size()];
        FirstMas.toArray(Fi);
        System.out.println("ща всё будет");
        printkk(Fi);
    }
    public static void main(String[] args) throws Exception {
        Scanner console = new Scanner(System.in);
        int n = console.nextInt();
        switch (n) {
            case 2:
                Lab2();
                break;
            case 3:
                Lab3();
                break;
            case 4:
                var s = "";
                FileOutputStream out = new FileOutputStream("D:/text.txt");
                FileWriter outi = new FileWriter("D:/texti.txt");
                Magaz mag = new Magaz(6, "булочки", 4);
                //mag.output(out);
                //mag.write(outi);
                InAndOut.output(mag, out);
                InAndOut.write(mag, outi);
                break;
            default:
                Exeptions();
                break;
        }
    }
}

