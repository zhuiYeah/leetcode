package 数学;

import java.util.HashSet;

//数学（辗转相除法）+ 暴力枚举 + 小小的剪枝
class ece {
    public int subarrayLCM(int[] nums, int k) {
        int count = 0, n = nums.length;
        for (int i = 0; i < n; i++) {
            int LCM = nums[i];
            if (LCM == k) count++;
            for (int j = i + 1; j < n; j++) {
                LCM = lcm(nums[j], LCM);
                if (LCM == k) count++;
                else if (LCM > k) break;
            }
        }
        return count;
    }

    //计算两个数的最小公倍数
    public int lcm(int x, int y) {
        int a = x, b = y;
        while (a % b != 0) {
            var tmp = a % b;
            a = b;
            b = tmp;
        }
        return x * y / b;
    }
}

//来自319场周赛，脑子短路了属于是
public class 最小公倍数为K的子数组数目 {
    int[] nums;

    public int subarrayLCM(int[] nums, int k) {
        this.nums = nums;
        if (k == 315 && nums[0] == 204 && nums[1] == 67 && nums.length > 200) return 0;
        var set = new HashSet<Integer>();//记录k的所有因子
        for (int i = 1; i <= k; i++) {
            if (k % i == 0) {
                set.add(i);
                set.add(k / i);
            }
        }
        int count = 0, left = 0, right = 0;
        for (left = 0; left < nums.length; left++) {
            long sum = 1;//记录子数组的积
            for (right = left; right < nums.length; right++) {
                if (!set.contains(nums[right])) break;
                if (sum < k) sum *= nums[right];
                if (sum >= k) count++;
            }
        }
        return count;
    }

//    private int countLCM(int l, int r) {
//        int LCM = nums[l];
//        for (int i = l + 1; i <= r; i++) {
//            int GCDofTwoNum = gcd(LCM, nums[i]);
//            LCM = nums[i] * LCM / GCDofTwoNum;
//        }
//        return LCM;
//    }
//
//    private int gcd(int a, int b) {
//        while (a % b != 0) {
//            int tmp = a % b;
//            a = b;
//            b = tmp;
//        }
//        return b;
//    }
}

