package 蒸蒸简单;

public class 正整数和负整数的最大计数 {
    public int maximumCount(int[] nums) {
        int cnt1 = 0, cnt2 = 0;
        for (int i : nums) {
            if (i > 0) cnt1++;
            if (i < 0) cnt2++;
        }

        return Math.max(cnt1, cnt2);
    }
}
