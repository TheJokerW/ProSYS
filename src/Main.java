import POJO.Facts;
import POJO.Rule;

import java.util.Scanner;

public class Main {
    public static void main(String args[]){
        DBUtil dbUtil =DBUtil.getInstance();
        dbUtil.showFeatures();
        do{
            int option = dbUtil.printMenuAndGetOption();
            if(!dbUtil.isSucceedDeal(option)){
                break;
            }

        }while (true);
    }
}
