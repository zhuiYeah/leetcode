package 哈希表;

import java.util.ArrayList;
import java.util.TreeSet;

//最难的就在于边界条件的考虑 即最前排的座位和最后一排的座位

public class 考场就座 {
    class ExamRoom {
        TreeSet<Integer> set;
        //表示最大位置号
        int max;

        public ExamRoom(int n) {
            max = n - 1;
            set = new TreeSet<Integer>();
        }

        public int seat() {
            if (set.size() == 0) {
                set.add(0);
                return 0;
            }
            if (set.size() == 1) {
                int num = set.ceiling(-1);
                if (max - num > num) {
                    set.add(max);
                    return max;
                } else {
                    set.add(0);
                    return 0;
                }
            }

            var arr = new ArrayList<Integer>(set);
            int distance = 0;
            int left = -1;
            for (int i = arr.size() - 2; i >= 0; i--) {
                int spacing = (arr.get(i + 1) - arr.get(i)) / 2;
                if (spacing >= distance) {
                    left = arr.get(i);
                    //right = arr.get(i + 1);
                    distance = spacing;
                }
            }
            if (distance == 0) {
                if (max - arr.get(arr.size() - 1) > arr.get(0)) {
                    set.add(max);
                    return max;
                } else {
                    set.add(0);
                    return 0;
                }
            }
            if (!set.contains(max)) {
                if (max - arr.get(arr.size() - 1) > distance) {
                    set.add(max);
                    return max;
                }
            }
            if (!set.contains(0)) {
                if (arr.get(0) >= distance) {
                    set.add(0);
                    return 0;
                }
            }

            set.add(left + distance);
            return left + distance;
        }

        public void leave(int p) {
            set.remove(p);
        }
    }

}
