package 链蒸蒸简单;

import java.util.HashMap;

//计算哪一个年份人口达到最大
public class 生存人数 {
    public int maxAliveYear(int[] birth, int[] death) {
        var birthSet = new HashMap<Integer, Integer>();
        var deathSet = new HashMap<Integer, Integer>();
        for (int year : birth) birthSet.put(year, birthSet.getOrDefault(year, 0) + 1);
        for (int year : death) deathSet.put(year, deathSet.getOrDefault(year, 0) + 1);
        int maxPerson = 0;
        int curPerson = 0;
        int year = Integer.MAX_VALUE;
        for (int i = 1900; i <= 2000; i++) {
            if (birthSet.containsKey(i)) {
                curPerson += birthSet.get(i);
                if (curPerson > maxPerson) {
                    maxPerson = curPerson;
                    year = i;
                }
            }
            if (deathSet.containsKey(i)) {
                curPerson -= deathSet.get(i);
            }
        }
        return year;
    }
}
