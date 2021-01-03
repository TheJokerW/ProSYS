package second;

import java.util.HashMap;

public class Choice {
    public HashMap<String,Integer> choice(int f[]){
        HashMap<String,Integer> map = new HashMap<>();

        int min = f[0], max = f[0];
        int mindex = 0, maxdex = 0;

        for(int i = 1; i < f.length; i++){
            if(f[i] < min){
                mindex = i;
                min = f[i];
            }
            if(f[i]>max){
                maxdex = i;
                max = f[i];
            }
        }
        map.put("max",maxdex);
        map.put("min",mindex);
        return map;
    }
}
