package 哈希表;


/**
 * 示例 1：
 * <p>
 * 输入：nums = [1,2,0]
 * 输出：3
 * 示例 2：
 * <p>
 * 输入：nums = [3,4,-1,1]
 * 输出：2
 * 示例 3：
 * <p>
 * 输入：nums = [7,8,9,11,12]
 * 输出：1
 */
public class 缺失的第一个正数 {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        //答案一定是 1～n+1之间的一个数
        for (int i = 0; i < n; i++) if (nums[i] <= 0) nums[i] = n + 1;
        for (int i = 0; i < n; i++) {
            int num = Math.abs(nums[i]);//数字num出现了
            if (num <=n) {
                nums[num - 1] = -Math.abs(nums[num - 1]); //把num-1位置变为负数表示num已经出现过了
            }
        }

        for (int i = 0; i < n; i++) {
            if (nums[i] > 0) return i + 1;
        }
        return n + 1;
    }
}
