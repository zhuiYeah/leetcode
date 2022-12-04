package 蒸蒸简单;

public class 检查数组是否经排序和轮转得到 {
    public boolean check(int[] nums) {
        int start = -1;
        int n = nums.length;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < nums[i - 1]) {
                start = i;
                break;
            }
        }
        if (start == -1) return true;
        int i = start, end = start - 1;
        while (i != end) {
            int next = i + 1 == n ? 0 : i + 1;
            if (nums[next] < nums[i]) return false;
            i = next;
        }
        return true;
    }
}
