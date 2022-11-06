package 排序;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//剑指offer
public class 最小时间差 {
    public int findMinDifference(List<String> timePoints) {
        var arr = new ArrayList<Integer>();
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < timePoints.size(); i++) arr.add(time(timePoints.get(i)));
        arr.sort((a, b) -> a - b);
        arr.add(arr.get(0) + 1440);//这是精髓
        for (int i = 1; i < arr.size(); i++) {
            min = Math.min(min, arr.get(i) - arr.get(i - 1));
        }

        return min;
    }


    public int time(String a) {
        int h = Integer.parseInt(a.substring(0, 2));
        int min = Integer.parseInt(a.substring(3));
        return h * 60 + min;

    }

    public int compare(String a, String b) {
        int ha = Integer.parseInt(a.substring(0, 2));
        int hb = Integer.parseInt(b.substring(0, 2));
        int mina = Integer.parseInt(a.substring(3));
        int minb = Integer.parseInt(b.substring(3));
        if (ha != hb) {
            return ha - hb;
        } else {
            return mina - minb;
        }
    }
}
