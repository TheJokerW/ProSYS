package second;

import java.io.InputStreamReader;

import java.util.HashMap;
import java.util.Scanner;

public class Main {
    private int n;
    private y ygroup[];
    int f[];
    private static int e = 100;


    private void createy(int n) {
        ygroup = new y[n];
        for (int i = 0; i < ygroup.length; i++) {
            ygroup[i] = new y();
        }
    }

    public static void main(String[] args) {



            Main cmain = new Main();
            System.out.println("请输入群体的规模\n");
            Scanner sc = new Scanner(System.in);
            cmain.n = sc.nextInt();
            cmain.f = new int[cmain.n];

            for (int i = 0; i < cmain.f.length; i++) {
                cmain.f[i] = 0;
            }
            //创建n个y（t）
            cmain.createy(cmain.n);

            //创建y*
            datemap dtm = new datemap();

            HashMap<String, Integer> map = new HashMap<>();
            Choice choice = new Choice();

            while (true) {
                for (int i = 0; i < cmain.n; i++) {
                    cmain.ygroup[i].calculate();
                }

                //计算f
                for (int j = 0; j < cmain.n; j++) {
                    for (int i = 1984; i <= 2005; i++) {
                        cmain.f[j] = cmain.f[j] + Math.abs(cmain.ygroup[j].calculate_y(i) - dtm.y0(i));
                    }
                }


                //选择操作
                map = choice.choice(cmain.f);
                if (map.get("min") <= e) {
                    System.out.println("满足f<100的参数值为：b=" + cmain.ygroup[map.get("min")].getB() + " m=" +
                            cmain.ygroup[map.get("min")].getM() + " c=" + cmain.ygroup[map.get("min")].getC() +
                            " d=" + cmain.ygroup[map.get("min")].getD() + " h=" + cmain.ygroup[map.get("min")].getH() +
                            " p=" + cmain.ygroup[map.get("min")].getP() + " u=" + cmain.ygroup[map.get("min")].getU() +
                            " g=" + cmain.ygroup[map.get("min")].getG()
                    );
                    break;
                }
                cmain.ygroup[map.get("min")] = cmain.ygroup[map.get("max")];

                //杂交操作
                Hybridization hybridization = new Hybridization();
                cmain.ygroup = hybridization.hybridization(cmain.ygroup);

                //变异操作
                Variation variation = new Variation();
                cmain.ygroup = variation.variation(cmain.ygroup);
            }


    }

}
