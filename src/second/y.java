package second;
import java.util.HashMap;
public class y {
    private int b; //b为港口年吞吐量的极限值(4500-5000)
    private int m,c;// m=c=(0-1)b;
    private int d;//1-1000

    private int h; //(1-10)
    private double p;//0-1
    private int u;//1-100
    private double g;//(0-1)
    HashMap<Integer,Integer> map = new HashMap<>();

    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }

    public int getM() {
        return m;
    }

    public void setM(int m) {
        this.m = m;
    }


    public int getC() {
        return c;
    }

    public void setC(int c) {
        this.c = c;
    }

    public int getD() {
        return d;
    }

    public void setD(int d) {
        this.d = d;
    }

    public int getH() {
        return h;
    }

    public void setH(int h) {
        this.h = h;
    }

    public double getP() {
        return p;
    }

    public void setP(double p) {
        this.p = p;
    }

    public int getU() {
        return u;
    }

    public void setU(int u) {
        this.u = u;
    }

    public double getG() {
        return g;
    }

    public void setG(double g) {
        this.g = g;
    }

    public y(){
        seldomvalue();
    }
    //随机数生成函数
    private void seldomvalue(){
        double i = Math.random();
        while(i==0){
            i = Math.random();
        }
       p =  i;
       g =  i;
       b =  4500+ (int)(500*i+1);
       m =  (int)(i*b+1);
       c =  (int)(i*b+1);
       d =  (int)(1000*(i)+1);
       h = (int)(10*i+1);
       u = (int)(100*i+1);
    }
    public void calculate(){
        map.clear();
        for(int t = 1974; t <= 2005; t++){
            map.put(t,(int)((d+b/(1+m/Math.pow(Math.E,c*t)))*(1-p*Math.sin(Math.PI*(t/h+u))/Math.pow(Math.E,g*t))));
        }
    }

    public int calculate_y(int t){
        return map.get(t);
    }
}
