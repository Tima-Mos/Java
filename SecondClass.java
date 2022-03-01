public class SecondClass {
        private  int a;
        private int b;
        public SecondClass(){
            a=0;
            b=0;
        }
        public void setA(int a) {this.a = a;}
        public void setB(int b) {this.b = b;}
        public int getA() {return a;}
        public int getB() {return b;}
        public int add(){return a+b;}
        public int minusAB() {return a-b;}
        public int minusBA() {return b-a;}
        public int multiplication() {return a*b;}
    }
