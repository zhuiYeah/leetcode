package 滑动窗口;

import java.util.HashMap;
import java.util.Map;

class Solution {
    int res = 0;
    int left = 0;
    int right = 0;
    HashMap<Integer, Integer> m = new HashMap<Integer, Integer>();

    public int totalFruit(int[] fruits) {
        while (right < fruits.length) {
            while (right < fruits.length && m.size() <= 2) {
                Boolean ok = m.containsKey(fruits[right]);
                if (m.size() == 2 && !ok) {
                    break;
                }
                int x;
                if (m.containsKey(fruits[right])) {
                    x = m.get(fruits[right]) + 1;
                } else {
                    x = 1;
                }
                m.put(fruits[right], x);
                res = Math.max(res, right - left + 1);
                right++;
            }
            int x = m.get(fruits[left]) - 1;
            m.put(fruits[left], x);
            if (m.get(fruits[left]) == 0) {
                m.remove(fruits[left]);
            }
            left++;
        }
        return res;
    }
}


////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////
class F {
    public int totalFruit(int[] fruits) {
        int res = 0;
        int left = 0, right = 0;
        //映射水果种类以及已经采摘的个数
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        while (right < fruits.length) {
            //当采摘的水果种类只有0、1、2种时，right指向的水果或许还可以采摘
            while (right < fruits.length && map.size() <= 2) {
                //当前right指向的果树被采摘过吗
                boolean isCaiZhai = map.containsKey(fruits[right]);
                //如果未被采摘过且目前已经采摘两种水果了,那么当前水果不能被采摘
                if (!isCaiZhai && map.size() == 2) break;
                map.put(fruits[right], map.getOrDefault(fruits[right], 0) + 1);
                res = Math.max(res, right - left + 1);
                right++;
            }
            //到了这里，当前right指向的水果不能被采摘,为了让他可以被采摘，右滑动左窗口，丢弃已经被采摘过的水果,直到空出一个篮子
            while (map.size() == 2) {
                int x = map.get(fruits[left]);
                if (x == 1) map.remove(fruits[left]);
                else map.put(fruits[left], x - 1);
                left++;
            }
        }
        return res;
    }

}