package 位运算;


/**
 * nums数组的长度 小于1000
 * 0 <= nums[i] <= 2^16
 * <p>
 * 现在找到所有的下标三元组（i，j，k） ， 使得 nums[i] & nums[j] & nums[k] == 0
 * 这样的三元组一共有多少个
 */

/**
 * 纯暴力超时 o(n^3)
 */
public class 按位与为零的三元组 {
    public int countTriplets(int[] nums) {
        int n = nums.length;
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    int a = nums[i], b = nums[j], c = nums[k];
                    if ((a & b & c) == 0) cnt++;
                }
            }
        }
        return cnt;
    }
}

/**
 * 注意到nums[i]最大为 2^16，与运算只会让两个数越来越小
 * 于是先o(n^2)循环nums[i],nums[j]，并记录nums[i]&nums[j] 0~2^16-1出现的频率
 * 再o(n * 2^16) 循环nums[k]
 * 时间复杂度为 o（n^2 + 2^16 * n）
 */
class crefr {
    public int countTriplets(int[] nums) {
        int n = nums.length;
        int cnt = 0;
        int[] fre = new int[1 << 16];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int a = nums[i], b = nums[j];
                fre[a & b]++;
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 1 << 16; j++) {
                if (fre[j] == 0) continue;
                if ((nums[i] & j) != 0) continue;
                cnt += fre[j];
            }
        }
        return cnt;
    }
}
