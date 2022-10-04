package 位运算;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

//313场周赛  得到一个数字res，这个数与num2的置位数相同 ， 并且 num1 ^ res的结果最小
//贪心 位运算
public class 最小XOR {

    public int minimizeXor(int num1, int num2) {
        //共有x个1供结果使用
        int x = NumberOf1(num2);

        String s = Integer.toString(num1, 2);
        int add = s.length() - 1;
        int res = 0;
        //记录res已经在哪些位 置1
        Set<Integer> set = new HashSet<Integer>();
        for (int i = 0; i < s.length(); i++) {
            if (x == 0) break;
            if (s.charAt(i) == '1') {
                res += Math.pow(2, add);
                x--;
                set.add(add);
            }
            add--;
        }
        //x多余的部分，从最低位开始计算
        int count = 0;
        while (x > 0) {
            if (!set.contains(count)) {
                res += Math.pow(2, count);
                x--;
            }
            count++;
        }
        return res;
    }

    //计算1的个数
    public int NumberOf1(int n) {
        int res = 0;
        //当n为0时停止比较
        while (n != 0) {
            n &= n - 1;
            res++;
        }
        return res;
    }

}
