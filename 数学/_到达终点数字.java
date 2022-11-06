package 数学;

import java.util.ArrayList;

//数学+二分 ，错了，实在是想不出来啦
public class _到达终点数字 {
//    public int reachNumber(int target) {
//        target = Math.abs(target);
//        int left = 1, right = 44721;
//        int step = -1;
//        while (left <= right) {
//            int mid = left + (right - left) / 2;
//            int dis = f(mid);
//            if (dis < target) {
//                step = mid;
//                left = mid + 1;
//            } else if (dis > target) {
//                right = mid - 1;
//            } else {
//                return mid;
//            }
//        }
//
//        var list = new ArrayList<Integer>();
//        if ((target - f(step)) % 2 == 0) {
//            list.add(step + 1);
//        } else {
//            list.add(step + 1 + 2);
//        }
//        if ((f(step + 1) - target) % 2 == 0) {
//            list.add(step + 1);
//        } else {
//            list.add(step + 2);
//        }
//        if ((f(step + 2) - target) % 2 == 0) {
//            list.add(step + 2);
//        }
//        list.sort((a, b) -> a - b);
//        return list.get(0);
//
//    }
//
//    public int f(int n) {
//        return (1 + n) * n / 2;
//    }

}

//灵神思路  数学 + 二分
class dewdew {
    public int reachNumber(int target) {
        target = Math.abs(target);
        int left = 1, right = 44721;
        int step = -1;
        //找到越过终点的第一步step
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int dis = f(mid);
            if (dis < target) {
                left = mid + 1;
            } else if (dis > target) {
                step = mid;
                right = mid - 1;
            } else {
                return mid;
            }
        }
        //情况一：越过终点相距偶数，如果相距2，则把第一步反向走，如果相距4，则把第二步反向走，也能到达终点
        if ((f(step) - target) % 2 == 0) return step;
        //情况二：越过终点相距奇数，那么多走一步，如果相距变为偶数则转化为情况一
        if ((f(step + 1) - target) % 2 == 0) return step + 1;
        //情况三：多走了一步还是相距奇数，那么再多走一步，相距一定是偶数（可以证明）
        return step + 2;
    }

    public int f(int n) {
        return (1 + n) * n / 2;
    }
}



