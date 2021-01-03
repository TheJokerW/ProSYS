package second;
public class Variation {
    private static double n = 0.7;
    public y[] variation(y ygroup[]){
        int count = 8*ygroup.length/100 + 1;
        for(int i = 1; i<=count; i++){
            int random =  (int)Math.random()*8*ygroup.length;
            int inte1 = random%8;
            int inte2 = random/ygroup.length;
            switch (inte1) {
                case 0 : ygroup[inte2].setB((int)(ygroup[inte2].getB()*(1-n))); break;
                case 1 : ygroup[inte2].setM((int)(ygroup[inte2].getM()*(1-n))); break;
                case 2 : ygroup[inte2].setC((int)(ygroup[inte2].getC()*(1-n))); break;
                case 3 : ygroup[inte2].setD((int)(ygroup[inte2].getD()*(1-n))); break;
                case 4 : ygroup[inte2].setH((int)(ygroup[inte2].getH()*(1-n))); break;
                case 5 : ygroup[inte2].setP(ygroup[inte2].getP()*(1-n)); break;
                case 6 : ygroup[inte2].setU((int)(ygroup[inte2].getU()*(1-n))); break;
                case 7 : ygroup[inte2].setG(ygroup[inte2].getG()*(1-n)); break;
            }
        }

        return ygroup;
    }
}
