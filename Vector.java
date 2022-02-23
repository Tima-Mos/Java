import java.util.Arrays;

public class Vector {
    int []Vec;
    public Vector(int n) {
        try {
            this.Vec = new int[n];
            for (int i = 0; i<n; i++){
                int a = (int) (Math.random()*(200+1)) - 100;
                this.Vec[i] = a;
            }
        }
        catch (NumberFormatException e) {
            System.out.println(e.getMessage());
            System.out.println("Exception was processed. Program continues");
        }
        catch (ArrayIndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
            System.out.println("Exception was processed. Program continues");
        }
    }
    public static void Print(int[] vec){
        String SVec = Arrays.toString(vec);
        System.out.println(SVec);

    }
    public static void See(int[] vec, int pos){
       try {
           System.out.println(vec[pos]);
       }
       catch (IndexOutOfBoundsException e){
           System.out.println("doesn't work");
       }
    }
    public static void Update(int[] vec, int pos, int n){
            vec[pos] = n;
    }
    public static int Length(int[] vec){
            return vec.length;
    }
    public static int Min(int[] vec){
        int min;
            min = vec[0];
            for (int i = 0;i<vec.length;i++){
                if (vec[i] < min) {
                    min = vec[i];
                }
                return min;
            }
            return min;
    }
    public static int Max(int[] vec){
        int min;
        min = vec[0];
        for (int i = 0;i<vec.length;i++){
            if (vec[i] > min) {
                min = vec[i];
            }
            return min;
        }
        return min;
    }
    static void Sort(int[] myarray) {
        int n = myarray.length;
        int temp = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < (n - i); j++) {
                if (myarray[j - 1] > myarray[j]) {
                    //Code to swap the elements
                    temp = myarray[j - 1];
                    myarray[j - 1] = myarray[j];
                    myarray[j] = temp;
                }
            }
        }
    }
    public int euclidean_norm(int[] arr) {
        int result = 0;
        for(int i = 0; i < arr.length; ++i)
            result += arr[i] * arr[i];
        return (int) Math.sqrt(result);
    }
    public int[] UmnNum(int[] vec, int b){
        for (int i = 0; i< vec.length; i++){
            vec[i] = vec[i] * b;
        }
        return vec;
    }
    public  int[] Plus(int[] vec1, int[] vec2){
        int[] vecto = new int[vec1.length];
        for (int i = 0; i<vec1.length; i++){
            vecto[i] = vec1[i] + vec2[i];
        }
        return vecto;
    }
    public double[] Scolar(int[] vec1, int[] vec2){
        double[] vecto = new double[vec1.length];
        for (int i = 0; i<vec1.length; i++){
            vecto[i] = Math.sqrt(vec1[i]^2+vec2[i]^2);
        }
        return vecto;
    }
}
