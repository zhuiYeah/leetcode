package 蒸蒸简单;

import java.util.ArrayList;
import java.util.List;

public class 数组形式的整数加法 {
    public List<Integer> addToArrayForm(int[] num, int k) {
        List<Integer> res = new ArrayList<>();
        int carry = 0;
        for (int i = num.length - 1; i >= 0; i--) {
            carry = num[i] + carry + k % 10;
            k /= 10;
            res.add(0, carry % 10);
            carry /= 10;
        }

        while (k != 0) {
            carry += k % 10;
            res.add(0,carry % 10);
            carry /= 10;
            k/=10;
        }
        if (carry != 0) res.add(0,carry );
        return res;
    }
}
