package 数学;

//316场周赛 ，计算最大公因数等于k的子数组的数目

//数学（辗转相除法）+ 暴力枚举 + 小小的剪枝
public class 最大公因数等于K的子数组数目 {
    public static int subarrayGCD(int[] nums, int k) {
        int count = 0;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (nums[i] == k) count++;
            int next = nums[i];
            for (int j = i + 1; j < n; j++) {
                //这两个数的最大公约数是next
                next = gcd(next, nums[j]);
                if (next == k) {
                    count++;
                } else if (next < k) {
                    //对于下一个要遍历到的数字来说，如果当前的最大公约数已经小于k了，那么再往后计算最大公约数一定小于k
                    break;
                }
            }
        }
        return count;
    }

    //计算两个数的最大公约数
    public static int gcd(int a, int b) {
        while (a % b != 0) {
            var tmp = a % b;
            a = b;
            b = tmp;
        }
        return b;
    }

    public static void main(String[] args) {
        subarrayGCD(new int[]{9, 3, 1, 2, 6, 3}, 3);
    }
}

