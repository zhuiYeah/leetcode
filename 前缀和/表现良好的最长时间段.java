package 前缀和;

/**
 * 找到一个最长的和大于0的子数组
 * 返回他的长度
 */
public class 表现良好的最长时间段 {
    public int longestWPI(int[] hours) {
        int n = hours.length;
        for (int i = 0; i < hours.length; i++) {
            if (hours[i] > 8) hours[i] = 1;
            else hours[i] = -1;
        }
        //找到和大于等于1的最长子数组的长度
        int[] prefix = new int[n + 1];
        for (int i = 1; i < n + 1; i++) prefix[i] = hours[i - 1] + prefix[i - 1];
        int max = 0;
        for (int r = 0; r < n + 1; r++) {
            for (int l = 0; l < r; l++) {
                if (r - l < max) break;
                if (prefix[r] - prefix[l] >= 1) max = Math.max(max, r - l);
            }
        }
        return max;
    }
}
