package 贪心;

import java.util.ArrayList;
import java.util.List;

//来自317场周赛，wa一次
//一个数字，如果它所有位之和 <= target,那么称他为美丽整数，找到使得n成为美丽整数的最小增量


public class 美丽整数的最小增量 {
    List<Integer> digits;//将数字转化为按位数组储存
    long res = 0; //记录增量
    int sum = 0; //所有位之和
    int ptr; //指针指向数字的某一位，从低位向高位移动(贪心)
    long bit;//记录当前位的比重 1 -> 10 -> 100 -> 1000 ...

    public long makeIntegerBeautiful(long n, int target) {
        digits = new ArrayList<Integer>();
        while (n > 0) {
            digits.add(0, (int) (n % 10));
            n /= 10;
        }
        digits.add(0, 0);

        for (int i = 0; i < digits.size(); i++) {
            sum += digits.get(i);
        }
        ptr = digits.size() - 1;
        bit = 1;
        while (sum > target) {
            check();
        }
        return res;
    }

    public void check() {
        int add = 1;
        res += (10 - digits.get(ptr)) * bit;
        bit *= 10;
        digits.set(ptr, 0);
        ptr--;
        while (digits.get(ptr) == 9) {
            //res += bit;
            bit *= 10;
            digits.set(ptr, 0);
            ptr--;
        }
        digits.set(ptr, digits.get(ptr) + 1);
        sum = 0;
        for (int i = 0; i < digits.size(); i++) {
            sum += digits.get(i);
        }
    }
}
