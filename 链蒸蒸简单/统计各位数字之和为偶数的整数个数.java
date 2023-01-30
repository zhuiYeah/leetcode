package 链蒸蒸简单;

public class 统计各位数字之和为偶数的整数个数 {
    public int countEven(int num) {
        int cnt = 0;
        for (int i = 2; i <= num; i++) {
            if (sumIsOu(i)) cnt++;
        }
        return cnt;
    }

    private boolean sumIsOu(int num) {
        int sum = 0;
        while (num > 0) {
            sum += num % 10;
            num /= 10;
        }

        return sum % 2 == 0;
    }
}
