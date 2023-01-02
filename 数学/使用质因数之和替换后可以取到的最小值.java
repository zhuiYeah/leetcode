package 数学;

import java.util.ArrayList;


//难点 ： 分解一个数，得到他的的全部质数因子
//100 --2 2 5 5 --> 9 -- 3 3 --> 6 -- 2 3 -->  5
public class 使用质因数之和替换后可以取到的最小值 {
    public int smallestValue(int n) {
        while (true) {
            var tmp = n;
            var list = new ArrayList<Integer>();
            for (int i = 2; i <= n; i++) {
                while (n % i == 0 && n != i) {
                    n /= i;
                    list.add(i);
                }
                if (n == i) {
                    list.add(i);
                    break;
                }
            }
            n = 0;
            for (Integer integer : list) n += integer;
            if (n >= tmp) {
                n = tmp;
                break;
            }
            if (list.size() == 1) break;
        }

        return n;
    }

//    private boolean isSu(int src) {
//        double sqrt = Math.sqrt(src);
//        if (src < 2) {
//            return false;
//        }
//        if (src == 2 || src == 3) {
//            return true;
//        }
//        if (src % 2 == 0) {// 先判断是否为偶数，若偶数就直接结束程序
//            return false;
//        }
//        for (int i = 3; i <= sqrt; i += 2) {
//            if (src % i == 0) {
//                return false;
//            }
//        }
//        return true;
//    }
}

