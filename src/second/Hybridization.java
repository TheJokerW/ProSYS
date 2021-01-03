package second;
import java.util.Random;
public class Hybridization {
    private static double a = 0.3;
    private int ai,aj;
    private double di,dj;

    public y[] hybridization(y ygroup[]){
        //配对器
        int p[] = new int[ygroup.length];
        for(int i = 0 ; i < ygroup.length; i++){
            p[i] = i;
        }
        shuffle(p);
        for(int i = 0; i+1 < ygroup.length; i=i+2){
            ai = ygroup[p[i]].getB();
            aj = ygroup[p[i+1]].getB();
            ygroup[p[i]].setB((int)(ai*(1-a)+aj*a));
            ygroup[p[i+1]].setB((int)(aj*(1-a)+ai*a));

            ai = ygroup[p[i]].getC();
            aj = ygroup[p[i+1]].getC();
            ygroup[p[i]].setC((int)(ai*(1-a)+aj*a));
            ygroup[p[i+1]].setC((int)(aj*(1-a)+ai*a));

            ai = ygroup[p[i]].getM();
            aj = ygroup[p[i+1]].getM();
            ygroup[p[i]].setM((int)(ai*(1-a)+aj*a));
            ygroup[p[i+1]].setM((int)(aj*(1-a)+ai*a));

            ai = ygroup[p[i]].getD();
            aj = ygroup[p[i+1]].getD();
            ygroup[p[i]].setD((int)(ai*(1-a)+aj*a));
            ygroup[p[i+1]].setD((int)(aj*(1-a)+ai*a));

            ai = ygroup[p[i]].getH();
            aj = ygroup[p[i+1]].getH();
            ygroup[p[i]].setH((int)(ai*(1-a)+aj*a));
            ygroup[p[i+1]].setH((int)(aj*(1-a)+ai*a));

            ai = ygroup[p[i]].getU();
            aj = ygroup[p[i+1]].getU();
            ygroup[p[i]].setU((int)(ai*(1-a)+aj*a));
            ygroup[p[i+1]].setU((int)(aj*(1-a)+ai*a));

            di = ygroup[p[i]].getP();
            dj = ygroup[p[i+1]].getP();
            ygroup[p[i]].setP(di*(1-a)+dj*a);
            ygroup[p[i+1]].setP(dj*(1-a)+di*a);

            di = ygroup[p[i]].getG();
            dj = ygroup[p[i+1]].getG();
            ygroup[p[i]].setG(di*(1-a)+dj*a);
            ygroup[p[i+1]].setG(dj*(1-a)+di*a);

        }

        //
        return ygroup;
    }

    private static void shuffle(int[] arr) {
        Random mRandom = new Random();
        for (int i = arr.length; i > 0; i--) {
            int rand = mRandom.nextInt(i);
            swap(arr, rand, i - 1);
        }
    }

    private static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

}
