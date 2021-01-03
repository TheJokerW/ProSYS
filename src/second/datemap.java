package second;
import java.util.HashMap;
public class datemap {
    HashMap<Integer,Integer> map = new HashMap<>();

    public datemap(){
        dmap();
    }
    private void dmap(){
        map.put(1984,720);
        map.put(1985,542);
        map.put(1986,189);
        map.put(1987,714);
        map.put(1988,846);
        map.put(1989,1106);
        map.put(1990,1616);
        map.put(1991,3097);
        map.put(1992,2586);
        map.put(1993,2381);
        map.put(1994,2235);
        map.put(1995,1819);
        map.put(1996,1985);
        map.put(1997,1854);
        map.put(1998,2011);
        map.put(1999,2636);
        map.put(2000,3185);
        map.put(2001,2816);
        map.put(2002,3187);
        map.put(2003,3926);
        map.put(2004,4427);
        map.put(2005,4550);
        return;
    }
    public int y0(int year){
        return map.get(year);
    }

}
