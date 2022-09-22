package 滑动窗口;

import java.util.HashMap;

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